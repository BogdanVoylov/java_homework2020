package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class StudentGroup {
    private List<Student> studentList;
    public StudentGroup(){
        this.studentList = new ArrayList<Student>();
    }

    public Student getStudentById(int id) {
        return studentList.get(id).clone();
    }

    public List<Student> findStudentByName(String searchString){
        List<Student> found = studentList.stream().filter(s->s.getName().contains(searchString)).collect(Collectors.toList());
        return copyStudentList(found);
    }

    public List<Student> getAllStudents(){
        return copyStudentList(studentList);
    }

    public List<Student> getStudentsWithMinGrade(){
        Collections.sort(studentList);
        return getFirstsWithSameGrade();
    }

    private List<Student> getFirstsWithSameGrade(){
        List<Student> res = new ArrayList<>();
        res.add(studentList.get(0));
        for(int i = 1; i < studentList.size() && studentList.get(i).getGrade() == res.get(res.size()-1).getGrade(); i++){
            res.add(studentList.get(i));
        }
        return copyStudentList(res);
    }

    public List<Student> getStudentsWithMaxGrade(){
        Collections.sort(studentList, Collections.reverseOrder());
        return getFirstsWithSameGrade();
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    private static List<Student> copyStudentList(List<Student> students){
        List<Student> res = new ArrayList<>();
        for(Student student : students)res.add(student.clone());
        return res;
    }

    @Override
    public String toString() {
        return studentList.toString();
    }
}
