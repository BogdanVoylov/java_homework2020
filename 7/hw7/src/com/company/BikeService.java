package com.company;

public class BikeService implements IService {
    @Override
    public void fixWheels() {
        System.out.println("Fixing bike wheels");
    }

    @Override
    public void fixEngine() {
        System.out.println("Fixing bike engine");
    }

    @Override
    public void fixElectronics() {
        System.out.println("Fixing bike electronics");
    }
}
