package com.company;

public class MotherBoard extends Device{
    public MotherBoard(){
        super(220,"Mother Board");
    }

    @Override
    public void turnOn() {
        isOn = true;
        for(Device device:connectedDevices){
            device.turnOn();
        }
    }

    @Override
    public void turnOff() {
        isOn = false;
        for(Device device:connectedDevices){
            device.turnOff();
        }
    }

    @Override
    public void connect(Device device) {
        addDevice(device);
        device.connect(this);
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
            System.out.println("+                 MotherBoard                   +");
            System.out.println("+        ********            ********           +");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            for(Device device:connectedDevices){
                device.doWork();
            }
        }

    }
}
