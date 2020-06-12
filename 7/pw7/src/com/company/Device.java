package com.company;

public abstract class Device implements IDevice{
    protected double energyConsumption;
    protected boolean isOn = false;
    protected Device[] connectedDevices;
    protected String name;
    protected void addDevice(Device device){
        Device[] newDevices = new Device[connectedDevices.length+1];
        for(int i = 0; i < connectedDevices.length; i++){
            newDevices[i] = connectedDevices[i];
        }
        newDevices[connectedDevices.length] = device;
        connectedDevices = newDevices;
    }
    public Device(double energyConsumption, String name){
        connectedDevices = new Device[0];
        this.energyConsumption = energyConsumption;
        this.name = name;
    }
}
