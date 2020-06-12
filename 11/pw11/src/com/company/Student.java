package com.company;

public class Student implements Comparable<Student>{
    String name;
    int grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }

    public Student clone(){
        return new Student(name,grade);
    }

    @Override
    public String toString() {
        return "{"+name+";"+grade+"}";
    }

    @Override
    public int compareTo(Student student) {
        return grade-student.getGrade();
    }
}
