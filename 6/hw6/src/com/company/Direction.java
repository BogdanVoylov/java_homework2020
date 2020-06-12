package com.company;

public class Direction extends Point{
    private double degree;
    public Direction(double degree){
        super(Math.cos(Math.toRadians(degree)), Math.sin(Math.toRadians(degree)));
        this.degree = Math.toRadians(degree);
    }
    private Direction(double x, double y){
        super(x,y);
    }

    public void changeDirection(double degree) {
        this.degree+=degree;
        this.x = Math.cos(this.degree);
        this.y = Math.sin(this.degree);
    }

    public Direction multiply(double d){
        return new Direction(x*d,y*d);
    }

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public double getY() {
        return super.getY();
    }
}
