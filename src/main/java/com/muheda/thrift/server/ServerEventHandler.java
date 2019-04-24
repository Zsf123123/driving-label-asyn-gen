package com.muheda.thrift.server;

import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.ServerContext;
import org.apache.thrift.server.TServerEventHandler;
import org.apache.thrift.transport.TTransport;

public class ServerEventHandler implements TServerEventHandler {


    @Override
    public void preServe() {

        System.out.println("Starting Server");


    }

    @Override
    public ServerContext createContext(TProtocol input, TProtocol output) {
        return null;
    }

    @Override
    public void deleteContext(ServerContext serverContext, TProtocol input, TProtocol output) {

        System.out.println();

    }

    @Override
    public void processContext(ServerContext serverContext, TTransport inputTransport, TTransport outputTransport) {

        System.out.println();
    }



}
