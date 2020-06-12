package com.company;

public class ServiceConsumer {
    public static void consumeService(IServiceFactory serviceFactory){
        IService service = serviceFactory.getService();
        service.fixWheels();
        service.fixEngine();
        service.fixElectronics();
    }
}
