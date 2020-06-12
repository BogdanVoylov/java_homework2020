package com.company;

public interface IDevice {
    void turnOn();
    void turnOff();
    void connect(Device device);
    void disconnect(int deviceIndex);
    void doWork();
}
