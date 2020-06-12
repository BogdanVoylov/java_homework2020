package com.company;

public class Transmission extends Detail {
    public Transmission(Car owner){
        super(owner);
    }

    public void switchMode(){
        super.getOwner().changeDirection(Math.PI);
    }
}
