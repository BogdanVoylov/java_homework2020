package com.company;

public class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) throws Exception {
        /*check for valid grade*/
        if (grade >= 0 && grade <= 100) {
            this.name = name;
            this.grade = grade;
        } else {
            throw new Exception();
        }
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "name: " + name + "\n" + "grade: " + grade;
    }
}
