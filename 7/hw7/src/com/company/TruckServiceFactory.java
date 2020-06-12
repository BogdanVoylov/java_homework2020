package com.company;

public class TruckServiceFactory implements IServiceFactory {
    @Override
    public IService getService() {
        return new TruckService();
    }
}
