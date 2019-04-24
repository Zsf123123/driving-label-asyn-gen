package com.muheda.thrift.produce;

import org.apache.thrift.TException;

import java.util.List;

public class ProduceHandler implements DrivingRouteData.Iface {


   private static   int num = 0;

    @Override
    public void ping() throws TException {

        System.out.println("hello");
    }

    @Override
    public int liveCheck() throws TException {

        return 0;
    }

    @Override
    public boolean sendDrivingRoute(String deviceId, List<LngAndLat> originRoute, List<LngAndLat> repaireLidst, List<LngAndLat> mappingRoad, String roadId) throws TException {

       //接收到rpc客户端传递过来的修复完成的数据



       return true;

    }



}
