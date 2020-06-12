package com.company;

public class Fuel {
    private FuelType fuelType;
    public Fuel(FuelType fuelType){
        this.fuelType = fuelType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return "Fuel:"+fuelType.name();
    }
}
