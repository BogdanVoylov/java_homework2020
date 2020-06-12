package com.company;

public class SteeringWheel extends Detail {
    public SteeringWheel(Car owner){
        super(owner);
    }

    public void changeDirection(int degrees){
        getOwner().changeDirection(Math.toRadians(degrees));
    }
}
