package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
Написати програму, що формує групу студентів і корисні методи.

Використовуючи колекції.

*/
public class Main {
    private static final String ADD_STUDENT_COMMAND = "add";
    private static final String GET_STUDENT_WITH_MIN_GRADE_COMMAND = "gswmng";
    private static final String GET_STUDENT_WITH_MAX_GRADE_COMMAND = "gswmxg";
    private static final String GET_GROUP_COMMAND = "gg";
    private static final String SEARCH_BY_NAME = "sbn";
    private static final String EXIT = "exit";
    private static final String HELP = "help";
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Написати програму, що формує групу студентів і корисні методи.\n" +
                "\n" +
                "Використовуючи колекції.");
        StudentGroup group = new StudentGroup();
        String input;
        while (true) {
            try {
                System.out.print("(main menu) Enter command> ");
                input = bufferedReader.readLine();
                if (input.equals(HELP)) {
                    System.out.format("%10s %1s %10s\n",ADD_STUDENT_COMMAND,":","for add new student");
                    System.out.format("%10s %1s %10s\n",GET_STUDENT_WITH_MIN_GRADE_COMMAND,":","for find student with min grade");
                    System.out.format("%10s %1s %10s\n",GET_STUDENT_WITH_MAX_GRADE_COMMAND,":","for find student with max grade");
                    System.out.format("%10s %1s %10s\n",GET_GROUP_COMMAND,":","for print group");
                    System.out.format("%10s %1s %10s\n",SEARCH_BY_NAME,":","for for searching by name");
                    System.out.format("%10s %1s %10s\n",EXIT+":","for exit from ()");
                    System.out.format("%10s %1s %10s\n",HELP+":","for list of commands");
                } else if (input.equals(ADD_STUDENT_COMMAND)) {
                    handleAddStudent(bufferedReader, group);
                } else if (input.equals(GET_STUDENT_WITH_MIN_GRADE_COMMAND)) {
                    System.out.println(group.getStudentsWithMinGrade().toString());
                } else if (input.equals(GET_STUDENT_WITH_MAX_GRADE_COMMAND)) {
                    System.out.println(group.getStudentsWithMaxGrade());
                } else if (input.equals(GET_GROUP_COMMAND)) {
                    System.out.println(group.toString());
                } else if (input.equals(SEARCH_BY_NAME)){
                    handleSearchByName(bufferedReader,group);
                }else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Wrong input");
            }
        }
    }

    public static void handleAddStudent(BufferedReader bufferedReader, StudentGroup group) throws Exception {
        String name = "";
        String input = "";
        int grade;
        while (true) {
            System.out.print("(add student menu) Enter name> ");
            input = bufferedReader.readLine();
            if (input.equals(HELP)) {
                System.out.println("You may only enter what is asked or '"+EXIT+"' to exit");
                continue;
            } else if (input.equals(EXIT)) {
                return;
            } else {
                name = input;
                break;
            }
        }

        while (true) {
            System.out.print("(add student menu) Enter grade> ");
            input = bufferedReader.readLine();
            if (input.equals(HELP)) {
                System.out.println("You may only enter what is asked or '"+EXIT+"' to exit");
                continue;
            } else if (input.equals(EXIT)) {
                return;
            } else {
                grade = Integer.valueOf(input);
                break;
            }
        }

        group.addStudent(new Student(name, grade));

    }

    private static void handleSearchByName(BufferedReader bufferedReader, StudentGroup studentGroup) throws IOException {
        while (true){
            System.out.print("(searching by name)Enter part of name:");
            String partOfName = bufferedReader.readLine();
            if(partOfName.equals(EXIT)){
                return;
            }
            System.out.println(studentGroup.findStudentByName(partOfName));
        }
    }
}

