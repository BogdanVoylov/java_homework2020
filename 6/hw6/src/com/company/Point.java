package com.company;

public class Point {
    protected double x;
    protected double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void move(Direction direction){
        x+=direction.getX();
        y+=direction.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "("+(int)x+";"+(int)y+")";
    }
}
