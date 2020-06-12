package com.company;

public class Car {
    private Wheel[] wheels;
    private Door[] doors;
    private Engine engine;
    private Point position;
    private Direction direction;
    private SteeringWheel steeringWheel;
    private Transmission transmission;
    private Fuel fuel;
    public Car(int enginePower, Point position){
        this.wheels = new Wheel[]{new Wheel(this), new Wheel(this), new Wheel(this), new Wheel(this)};
        this.doors = new Door[]{new Door(this),new Door(this),new Door(this),new Door(this)};
        this.steeringWheel = new SteeringWheel(this);
        this.engine = new Engine(enginePower,this);
        this.position = position;
        this.direction = new Direction(0);
        transmission = new Transmission(this);
    }
    public  void rotateWheel(int degrees){
        steeringWheel.changeDirection(degrees);
    }
    public String fillFuel(Fuel fuel){
        this.fuel = fuel;
        return "Filled with fuel ";
    }
    public String openDoor(int x){
        if(engine.isWorking()){
            return "Cannot open door because engine is working";
        }
        doors[x].open();
        return "Door "+x+" opened";
    }
    public String closeDoor(int x){
        doors[x].close();
        return "Door "+x+" closed";
    }
    public String start(){
        if(engine.isWorking()){
            return "Already started";
        }
        for(int i = 0; i<doors.length;i++){
            if(!doors[i].isClosed()){
                return "Cannot start. Door "+i+" is opened";
            }
        }
        engine.start();
        return "Started";
    }
    public String stop(){
        if(!engine.isWorking()){
            return "Already not working";
        }
        engine.stop();
        return "Stopped";
    }
    public String move(){
        this.position.move(direction.multiply(engine.run()));
        return position.toString();
    }
    public void switchTransmission(){
        transmission.switchMode();
    }
    @Override
    public String toString(){
        String doors = "";
        for (Door door:this.doors) {
            doors+=(door+"\n");
        }
        return "Car at position "+position+"\n"+engine.toString()+"\n"+doors;
    }
    void changeDirection(double degree) {
        direction.changeDirection(degree);
    }
}
