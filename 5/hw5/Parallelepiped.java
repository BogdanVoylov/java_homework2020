package com.company;

public class Parallelepiped {
    private Parallelogram p;
    private int sideHeight;
    private double height;
    public Parallelepiped(Parallelogram p, int height){
        this.p = p;
        this.height = height;
    }
    public Parallelepiped(Parallelogram p, int sideHeight, int degree){
        this.p = p;
        this.height = sideHeight*Math.sin(Math.toRadians(degree));
    }
    public double bottomSquare(){
        return p.square();
    }
    public double volume(){
        return p.square()*height;
    }
}
