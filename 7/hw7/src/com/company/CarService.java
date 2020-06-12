package com.company;

public class CarService implements IService {
    @Override
    public void fixWheels() {
        System.out.println("Fixing car wheels");
    }

    @Override
    public void fixEngine() {
        System.out.println("Fixing car engine");
    }

    @Override
    public void fixElectronics() {
        System.out.println("Fixing car electronics");
    }
}
