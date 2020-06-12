package com.company;

public class Vector {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector(Point p1, Point p2) {
        x = p2.x - p1.x;
        y = p2.y - p1.y;
    }

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double multiply(Vector v1){
        return x*v1.x+y*v1.y;
    }
}

