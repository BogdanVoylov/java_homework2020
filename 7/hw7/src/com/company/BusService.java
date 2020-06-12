package com.company;

public class BusService implements IService {
    @Override
    public void fixWheels() {
        System.out.println("Fixing bus wheels");
    }

    @Override
    public void fixEngine() {
        System.out.println("Fixing bus engine");
    }

    @Override
    public void fixElectronics() {
        System.out.println("Fixing bus electronics");
    }
}
