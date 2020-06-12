package com.company;

public class Tesla extends Car implements IAutopiloted {
    private boolean isOnAutopilot = false;

    public Tesla(int enginePower, Point position) {
        super(enginePower, position);
    }

    public String turnOnAutopilot() {
        isOnAutopilot = true;
        return "AutoPilot turned on successfully";
    }

    public String turnOffAutopilot() {
        isOnAutopilot = false;
        return "AutoPilot turned off successfully";

    }

    @Override
    public String fillFuel(Fuel fuel) {
        if (fuel.getFuelType() == FuelType.Electricity) {
            return "Filled";
        } else {
            return "Cannot be filled with " + fuel;
        }
    }

    @Override
    public void rotateWheel(int degrees) {
        if (isOnAutopilot) {
            System.out.println("No sense. Autopilot is on!");
        } else {
            super.rotateWheel(degrees);
        }
    }

    @Override
    public String toString() {
        return "(Tesla)" + super.toString() + "Is autopilot on: " + isOnAutopilot;
    }
}
