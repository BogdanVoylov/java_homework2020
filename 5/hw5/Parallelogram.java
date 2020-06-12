package com.company;

public class Parallelogram {
    private Vector v1;
    private Vector v2;
    public Parallelogram(Vector v1, Vector v2){
        this.v1 = v1;
        this.v2 = v2;
    }
    public Parallelogram(Point p1, Point p2, Point p3){
        this.v1 = new Vector(p1,p2);
        this.v2 = new Vector(p1,p3);
    }
    public double square(){
        int X = v1.getY()*v2.getZ() - v1.getZ()*v2.getY();
        int Y = v1.getZ()*v2.getX() - v1.getX()*v2.getZ();
        int Z = v1.getX()*v2.getY() - v1.getY()*v2.getX();
        return Math.sqrt(Math.pow(X,2)+Math.pow(Y,2)+Math.pow(Z,2));
    }
}
