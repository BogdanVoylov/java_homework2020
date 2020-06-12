package com.company;
/*Написати свою реалізацію абстрактної фабрики: мийка або СТО для машин*/
public class Main {

    public static void main(String[] args) {
        ServiceConsumer.consumeService(new BikeServiceFactory());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        ServiceConsumer.consumeService(new CarServiceFactory());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        ServiceConsumer.consumeService(new BusServiceFactory());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        ServiceConsumer.consumeService(new TruckServiceFactory());
    }
}
