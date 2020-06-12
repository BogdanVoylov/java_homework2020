package com.company;

public class Engine extends Detail{
    private int power;
    private boolean works;
    public Engine(int power, Car owner){
        super(owner);
        this.power = power;
    }
    public void start(){
        this.works = true;
    }
    public void stop(){
        this.works = false;
    }
    public int run(){return works ? power : 0;}
    public boolean isWorking(){
        return works;
    }
    @Override
    public String toString() {
        return "Engine:\n Power: "+power+";\n Is working: "+works;
    }
}
