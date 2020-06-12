package com.company;

public class Circle extends Figure{
    private double radius;
    public Circle(Point center, Point oneFromBorder){
        points = new Point[]{center};
        radius = center.distanceTo(oneFromBorder);
    }

    @Override
    public double square() {
        return Math.PI*Math.pow(radius,2);
    }

    @Override
    public double borderLength() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Circle with radius at "+points[0]+" and radius "+radius;
    }
}
