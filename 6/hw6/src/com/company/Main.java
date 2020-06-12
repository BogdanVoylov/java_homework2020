package com.company;
/*Переробити ієрархію класів car з попереднього практичного так, щоб показати потужність поліморфізму.

        Написати клас тестер.*/
public class Main {

    public static void main(String[] args) {
	// write your code here
        Car[] cars = createCars();
        for(Car car:cars){
            //only tesla can use autopilot and only amphibian can pressurize
            try {
                System.out.println(((IAmphibian)car).pressurization());
            }catch (Exception e){
                System.out.println("This car is not amphibian");
            }
            try {
                System.out.println(((IAutopiloted)car).turnOnAutopilot());
            } catch (Exception e){
                System.out.println("This car is not autopiloted");
            }
            System.out.println(car.fillFuel(new Fuel(FuelType.Electricity)));
            System.out.println(car.fillFuel(new Fuel(FuelType.OR89)));

            System.out.println(car);
        }
    }

    //creates cars
    private static Car[] createCars(){
        return new Car[]{new Amphibian(100,new Point(0,0)), new Tesla(100,new Point(1,0))};
    }
}
