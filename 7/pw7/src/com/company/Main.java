package com.company;
/*Написати свій приклад з використанням абстрактних класів і інтерфейсів.*/
public class Main {

    public static void main(String[] args) {
        MotherBoard motherBoard = new MotherBoard();
        motherBoard.connect(new VideoCard(220,"NVIDIA"));
        motherBoard.connect(new Processor(220,"i7-8750h"));
        motherBoard.turnOn();
        motherBoard.doWork();
    }
}
