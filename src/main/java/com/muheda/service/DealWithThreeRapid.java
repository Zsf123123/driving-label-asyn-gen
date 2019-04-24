package com.muheda.service;


import clojure.lang.IFn;
import com.muheda.dao.DrivingLabelDao;
import com.muheda.domain.DriveData;
import com.muheda.domain.ThriftSend;
import com.muheda.thrift.produce.DrivingRouteData;
import com.muheda.domain.LngAndLat;
import com.muheda.utils.DateUtils;

import org.apache.log4j.Logger;


import java.util.*;


/**
 * @desc 用于处理实时三急数据
 *
 *
 */
public class DealWithThreeRapid {


    private  static Logger logger = Logger.getLogger(DealWithThreeRapid.class);


    // 存放用户设备号与之对应的上一次的行程
    private  static Map<String,List<LngAndLat>> lastRoutes =  new HashMap<String,List<LngAndLat>>();



    /**
     * @desc 将原来的lngAndLat转成 com.muheda.thrift.produce.LngAndLat，起始就是将时间格式进行转换
     * @return
     */
    public  static List<LngAndLat>  transferLngAndLat(List<com.muheda.thrift.produce.LngAndLat> list){

        int size = list.size();

        List<LngAndLat> resultList = new ArrayList<LngAndLat>(size);


        for (int i = 0; i < size; i++) {

            LngAndLat lngAndLat = new LngAndLat();

            com.muheda.thrift.produce.LngAndLat lngAndLat1 = list.get(i);
            lngAndLat.setLng(lngAndLat1.getLng());
            lngAndLat.setLat(lngAndLat1.getLat());
            lngAndLat.setDeviceId(lngAndLat1.getDeviceId());

            //至关重要的，将字符串类型的时间转成Date类型数据
            lngAndLat.setDate(DateUtils.parseDate(lngAndLat1.getTime(),DateUtils.DATETIME_FORMAT));

            resultList.add(lngAndLat);


        }

        return resultList;

    }



    /**
     * @desc 将传过来的修复完成的行程进行实时三急计算并进行相关的记录
     * @param deviceId     设备号
     * @param originRoute  原始数据的行程
     * @param thisRoute    用于真正做计算三急的行程数据
     * @param mappingRoad  映射到路网的数据
     * @param roadId       对应路网的Id
     */
   public void dealWithThreeRapid( String deviceId, List<LngAndLat> originRoute, java.util.List<LngAndLat> thisRoute, List<LngAndLat> mappingRoad, String roadId){


          LngAndLat thisPoint = thisRoute.get(0);

          if(thisPoint == null){
              return;
          }


            // 根据用户名获取用户的上一段行程，暂时存放在内存中。可以将数据优化存放在redis中
           List<LngAndLat> lastRoute = lastRoutes.get(deviceId);


            // 如果此时的上一段行程为空,则直接计算该行程的急加速，急减速
            if(lastRoute == null){

               //在此处对行程进行非空判断
               Map<String, Object> thisRouteMap = splitRouteToArray(thisRoute);

               //只算急加速，急减速
               DriveData urgentSpeed = new SafetyDrivingCheck().getSpeedCheck( (List<Double>) thisRouteMap.get("lon"),  (List<Double>) thisRouteMap.get("lat"), (List<Date>) thisRouteMap.get("time"));

               //todo:将计算的急加速，急减速存储起来

                if(urgentSpeed != null){

                    DrivingLabelDao.saveRouteUrgentSpeedLabel("deviceId", urgentSpeed);
                }

               // 进行更新上次行程
               lastRoutes.put(deviceId,thisRoute);

               return;
            }


           String  thisDeviceId = thisPoint.getDeviceId();
           Date  thisDate = thisPoint.getDate();

           SafetyDrivingCheck safetyDrivingCheck = new SafetyDrivingCheck();

           List<Double> lon  = null;
           List<Double> lat  = null;
           List<Date>   time = null;


           DriveData  urgentSpeed = null;
           DriveData  urgentSharpTurn  = null;


           // 取出上一次行程的最后的一个点，找出该点的设备号和时间以及最后一个点的坐标

           // 上一次行程的最后一个点
           LngAndLat lastRouteLastPoint = lastRoute.get(lastRoute.size());
           Date lastRouteTime = lastRouteLastPoint.getDate();

            // 如果此时的上一段行程不为空，但是上一段行程与现在的行程不是属于同一个设备,或者此时的这段行程与上一段的时间差过大。 则也是进行单独的计算
           if(lastRoute != null &&  deviceId.equals(thisDeviceId) || DateUtils.getDiffDate(thisDate, lastRouteTime, 12) < 10){


               Map<String, Object> thisRouteMap = splitRouteToArray(thisRoute);

               lon  = (List<Double>) thisRouteMap.get("lon");
               lat  = (List<Double>) thisRouteMap.get("lat");
               time = (List<Date>)thisRouteMap.get("time");


               //急加速,急减速
               urgentSpeed = safetyDrivingCheck.getSpeedCheck(lon, lat, time);



               //急转弯，在计算急转弯的时候，需要将上次行程的结束点插入现有的行程之中
               urgentSharpTurn = safetyDrivingCheck.getSharpTurnCheck( lastRouteLastPoint,lon, lat, time);

               if(urgentSpeed != null){

                   DrivingLabelDao.saveRouteUrgentSpeedLabel("deviceId", urgentSpeed);
               }

               if(urgentSharpTurn != null){

                   //将标签数据存储到hbase中
                   DrivingLabelDao.saveRouteUrgentSharpTurn("deviceId", urgentSharpTurn);
               }



           }else {

               //如果不满足条件
               Map<String, Object> thisRouteMap = splitRouteToArray(thisRoute);

               System.out.println("正在计算急加速和急减速");
               //急加速,急减速
               urgentSpeed = safetyDrivingCheck.getSpeedCheck(lon, lat, time);

               //将此行程更新为上次
               lastRoutes.put(deviceId,thisRoute);
               return;

           }


   }




        /**
         * @desc 将行程切割成经度数组的集合和纬度数组的集合和时间数组的集合
         * @param route
         * @return  返回类型为Map，里面的key为 "lon", "lat" ,"time"
         */
        public static   Map<String,Object> splitRouteToArray(List<com.muheda.domain.LngAndLat>  route){

            Map<String, Object> resultMap = new HashMap<>();

            int size = route.size();

            List<Double> lon  = new ArrayList<>();
            List<Object> lat  = new ArrayList<>();
            List<Date>   time = new ArrayList<>();


            for (int i = 0; i < size; i++) {

                com.muheda.domain.LngAndLat lngAndLat = route.get(i);
                lon.add(lngAndLat.getLng());
                lat.add(lngAndLat.getLat());
                time.add(lngAndLat.getDate());
            }


            resultMap.put("lon", lon);
            resultMap.put("lat", lat);
            resultMap.put("time", time);


            return  resultMap;

        }






}
