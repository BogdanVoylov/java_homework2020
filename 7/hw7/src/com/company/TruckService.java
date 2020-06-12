package com.company;

public class TruckService implements IService {
    @Override
    public void fixWheels() {
        System.out.println("Fixing truck wheels");
    }

    @Override
    public void fixEngine() {
        System.out.println("Fixing truck engine");
    }

    @Override
    public void fixElectronics() {
        System.out.println("Fixing truck electronics");
    }
}
