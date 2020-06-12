package com.company;

public class Processor extends Device {
    public Processor(double energyConsumption, String name) {
        super(energyConsumption, name);
    }

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    @Override
    public void connect(Device device) {
        addDevice(device);
    }

    @Override
    public void disconnect(int deviceIndex) {
        connectedDevices[deviceIndex] = null;
    }

    @Override
    public void doWork() {
        if(isOn){
            System.out.println(name);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+        ********            ********           +");
            System.out.println("+                  Processor                    +");
            System.out.println("+        ********            ********           +");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }
}
