package com.company;
public class Test {

    private int i;

    class C{
    }

    private C getC(){

        return new C(){

            {i=5;}

        };

    }

    void doSmth(){

        getC();

        System.out.println(i);

    }

    public static void main(String[] args) {Test t = new Test();t.doSmth();}

}