package com.company;

public class BikeServiceFactory implements IServiceFactory{

    @Override
    public IService getService() {
        return new BikeService();
    }
}
