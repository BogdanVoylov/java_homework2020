package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private Student[] students;

    public Group() {
        students = new Student[0];
    }

    public void addStudent(Student student) {
        Student[] newStudents = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
        }
        newStudents[students.length] = student;
        students = newStudents;
    }

    /*sorts student by grade and one with biggest is the last and one with lowest is the first*/
    public Student getStudentWithMaxGrade() {
        Arrays.sort(students, Comparator.comparing(Student::getGrade));
        return students[students.length - 1];
    }

    public Student getStudentWithMinGrade() {
        Arrays.sort(students, Comparator.comparing(Student::getGrade));
        return students[0];
    }

    @Override
    public String toString() {
        String res = "*******************************\n";
        for (Student student : students) {
            res += student.toString();
            res += "\n*******************************\n";
        }
        return res;
    }
}
