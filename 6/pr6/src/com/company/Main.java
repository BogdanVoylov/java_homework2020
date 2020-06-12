package com.company;
/*
* Написати клас геометрична фігура, в якому визначити стандартні методи і поля.

Написати похідні класи коло, чотирикутник, трикутник, в яких перевизначити методи базового класу.

Написати клас прямокутник який розширить чотирикутник.*/
public class Main {

    public static void main(String[] args) {
	// write your code here
        Figure circle = new Circle(new Point(0,0),new Point(1,1));
        System.out.println(circle);
        System.out.println("Circle square "+circle.square());
        System.out.println("Circle border length "+circle.borderLength());
        //tests tetragon
        Figure tetragon = new Tetragon(new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,0));
        System.out.println(tetragon);
        System.out.println("Tetragon square "+tetragon.square());
        System.out.println("Tetragon border length "+tetragon.borderLength());
        //tests triangle
        Triangle triangle = new Triangle(new Point(0,0), new Point(0,1), new Point(1,0));
        System.out.println(triangle);
        System.out.println("Triangle square "+triangle.square());
        System.out.println("Triangle border length "+triangle.borderLength());
        //tests rectangle
        Rectangle rectangle = null;
        //if any angle is not 90 then exception wil be thrown
        try {
            rectangle = new Rectangle(new Point(0,0), new Point(0,1), new Point(1,1), new Point(2,0));
        } catch (Exception e) {
            System.out.println("Not rectangle");
            return;
        }
        System.out.println(rectangle);
        System.out.println("Rectangle square "+rectangle.square());
        System.out.println("Rectangle border length "+rectangle.borderLength());
    }
}
