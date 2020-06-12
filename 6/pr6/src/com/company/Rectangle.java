package com.company;

public class Rectangle extends Tetragon {

    public Rectangle(Point a, Point b, Point c, Point d) throws Exception {
        super(a, b, c, d);
        Vector v1 = new Vector(a,b);
        Vector v2 = new Vector(b,c);
        Vector v3 = new Vector(c,d);
        Vector v4 = new Vector(a,d);
        if(!(v1.multiply(v2) == 0 && v2.multiply(v3)==0 && v3.multiply(v4)==0 && v4.multiply(v1)==0)){
            throw new Exception();
        }
    }

    @Override
    public String toString() {
        return "(Rectangle)"+super.toString();
    }
}
