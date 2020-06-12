package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Car car = new Car(100,new Point(0,0));
        printCar(car);
        System.out.println("Attempt to start: "+car.start());
        System.out.println("One more attempt to start: "+car.start());
        System.out.println("Attempt to stop: "+car.stop());
        System.out.println("One more attempt to stop: "+car.stop());
        System.out.println("Opening door: "+car.openDoor(1));
        System.out.println("Attempt to start: "+car.start());
        System.out.println("Closing door: "+car.closeDoor(1));
        System.out.println("Attempt to start: "+car.start());
        System.out.println("Opening door: "+car.openDoor(1));
        System.out.println("Moving: "+car.move());
        System.out.println("Rotating wheel to 90 degrees");
        car.rotateWheel(90);
        System.out.println("Moving: "+car.move());
        System.out.println("Switch transmission.");
        car.switchTransmission();
        System.out.println("Moving: "+car.move());
        printCar(car);
    }

    private static void printCar(Car car){
        System.out.println("******************************************************************");
        System.out.println(car);
        System.out.println("******************************************************************");
    }
}
