package com.muheda.thrift.server;

import com.muheda.thrift.produce.DrivingRouteData;
import com.muheda.thrift.produce.ProduceHandler;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.net.InetSocketAddress;

public class Server {


    public static ProduceHandler handler;


    public static DrivingRouteData.Processor<ProduceHandler> processor;


    private static Logger log = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) throws TTransportException {


        try {


            handler = new ProduceHandler();

            processor = new DrivingRouteData.Processor<ProduceHandler>(handler);

            InetSocketAddress inetSocketAddress = new InetSocketAddress(9999);

            TNonblockingServerTransport serverSocket = new TNonblockingServerSocket(inetSocketAddress);

            TThreadedSelectorServer.Args serverParams = new TThreadedSelectorServer.Args(serverSocket);
            serverParams.selectorThreads(1);
            serverParams.workerThreads(1);

            serverParams.protocolFactory(new TBinaryProtocol.Factory());
            //非阻塞
            serverParams.transportFactory(new TFramedTransport.Factory());
            serverParams.processor(processor);

            TServer server = new TThreadedSelectorServer(serverParams);

            server.setServerEventHandler(new ServerEventHandler());

            server.serve();

            System.out.println("服务启动成功");

        } catch (Exception ex) {

            ex.printStackTrace();
            log.error(ex.getMessage(), ex);
            System.exit(-1);
        }
    }

}
