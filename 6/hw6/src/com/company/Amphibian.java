package com.company;

public class Amphibian extends Car implements IAmphibian {
    private boolean isPressurized = false;
    public Amphibian(int enginePower, Point position) {
        super(enginePower, position);
    }

    public boolean isPressurized() {
        return isPressurized;
    }

    public String pressurization(){
        isPressurized = true;
        return "Pressurized successfully";
    }

    public String depressurization(){
        isPressurized = false;
        return "Depressurized successfully";
    }

    @Override
    public String fillFuel(Fuel fuel) {
        if(fuel.getFuelType() == FuelType.OR89){
            return "Filled";
        }else{
            return "Cannot be filled with "+fuel;
        }
    }

    @Override
    public String toString() {
        return "Amphibian car "+super.toString()+"Is pressurized:"+isPressurized;
    }
}
