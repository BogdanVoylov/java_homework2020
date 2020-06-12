package com.company;

public class Triangle extends Figure {
    public Triangle(Point a, Point b, Point c){
        points = new Point[]{a,b,c};
    }
    @Override
    public double square() {
        return 0.5*Math.abs(points[0].x*points[1].y+points[1].x*points[2].y+points[2].x*points[0].y-
                (points[0].y*points[1].x+points[1].y*points[2].x+points[2].y*points[0].x));
    }

    @Override
    public double borderLength() {
        return points[0].distanceTo(points[1])+points[1].distanceTo(points[2])+points[2].distanceTo(points[0]);

    }

    @Override
    public String toString() {
        return "Triangle with points:\n"+points[0]+"\n"+points[1]+"\n"+points[2]+";";
    }
}
