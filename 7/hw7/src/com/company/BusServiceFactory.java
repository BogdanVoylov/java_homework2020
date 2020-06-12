package com.company;

public class BusServiceFactory implements IServiceFactory {

    @Override
    public IService getService() {
        return new BusService();
    }
}
