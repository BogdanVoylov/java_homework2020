package com.company;

public class CarServiceFactory implements IServiceFactory {
    @Override
    public IService getService() {
        return new CarService();
    }
}
