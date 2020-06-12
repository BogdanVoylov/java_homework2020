package com.company;

public class Point {
    public double x;
    public double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double distanceTo(Point p){
        return Math.sqrt(Math.pow(x-p.x,2)+(Math.pow(y-p.y,2)));
    }
    @Override
    public String toString() {
        return "Point("+x+","+y+")";
    }
}
