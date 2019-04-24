package com.muheda.domain;


import com.muheda.thrift.produce.DrivingRouteData;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftSend {


    private TFramedTransport transport;

    private DrivingRouteData.Client client;

    public DrivingRouteData.Client getClient() {
        return client;
    }

    public void setClient(DrivingRouteData.Client client) {
        this.client = client;
    }


    public void setTransport(TFramedTransport transport) {
        this.transport = transport;
    }

    public TFramedTransport getTransport() {
        return transport;
    }

    public void openTransport() throws TTransportException {

        if(!this.transport.isOpen()){
            this.transport.open();
        }

    }

}