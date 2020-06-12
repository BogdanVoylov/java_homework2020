package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Parallelogram p = new Parallelogram(new Point(0,0,0),new Point(0,1,0),new Point(1,0,0));
        System.out.println(p.square());
        Parallelepiped pd = new Parallelepiped(p,1);
        System.out.println(pd.volume());
        Parallelogram p1 = new Parallelogram(new Point(1,5,0),new Point(5,0,0),new Point(0,0,0));
        System.out.println(p1.square());
        Parallelepiped pd1 = new Parallelepiped(p1,5);
        System.out.println(pd1.volume());
        Parallelogram p2 = new Parallelogram(new Point(1,0,0), new Point(0,5,0), new Point(6,0,0));
        Parallelepiped pd2 = new Parallelepiped(p2,5);
        System.out.println(p2.square());
        System.out.println(pd2.volume());
    }
}
