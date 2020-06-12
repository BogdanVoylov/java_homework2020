package com.company;

public abstract class Detail {
    private Car owner;
    public Detail(Car owner){
        this.owner = owner;
    }
    protected Car getOwner(){
        return owner;
    }
}
