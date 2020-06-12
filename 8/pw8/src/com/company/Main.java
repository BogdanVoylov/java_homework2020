package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Написати програму, що формує групу студентів.

Інформація про студентів (ПІБ, середній бал, адреса і т.д.) вводиться з клавіатури.

Групу, студента та введення інформації оформити у вигляді окремих класів.

Написати клас тестер який заповнює групу, виводить інформацію про групу студентів та повертає студента з найкращим і найгіршим балом.*/
public class Main {
    private static final String ADD_STUDENT_COMMAND = "add";
    private static final String GET_STUDENT_WITH_MIN_GRADE_COMMAND = "gswmng";
    private static final String GET_STUDENT_WITH_MAX_GRADE_COMMAND = "gswmxg";
    private static final String GET_GROUP_COMMAND = "gg";

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Написати програму, що формує групу студентів.\n" +
                "\n" +
                "Інформація про студентів (ПІБ, середній бал, адреса і т.д.) вводиться з клавіатури.\n" +
                "\n" +
                "Групу, студента та введення інформації оформити у вигляді окремих класів.\n" +
                "\n" +
                "Написати клас тестер який заповнює групу, виводить інформацію про групу студентів та повертає студента з найкращим і найгіршим балом." +
                "\n" +
                "if in menu type 'help' for help");
        Group group = new Group();
        String input;
        while (true) {
            try {
                System.out.print("(main menu) Enter command> ");
                input = bufferedReader.readLine();
                if (input.equals("help")) {
                    System.out.format("%10s %1s %10s\n",ADD_STUDENT_COMMAND,":","for add new student");
                    System.out.format("%10s %1s %10s\n",GET_STUDENT_WITH_MIN_GRADE_COMMAND,":","for find student with min grade");
                    System.out.format("%10s %1s %10s\n",GET_STUDENT_WITH_MAX_GRADE_COMMAND,":","for find student with max grade");
                    System.out.format("%10s %1s %10s\n",GET_GROUP_COMMAND,":","for print group");
                } else if (input.equals(ADD_STUDENT_COMMAND)) {
                    handleAddStudent(bufferedReader, group);
                } else if (input.equals(GET_STUDENT_WITH_MIN_GRADE_COMMAND)) {
                    System.out.println(group.getStudentWithMinGrade().toString());
                } else if (input.equals(GET_STUDENT_WITH_MAX_GRADE_COMMAND)) {
                    System.out.println(group.getStudentWithMaxGrade());
                } else if (input.equals(GET_GROUP_COMMAND)) {
                    System.out.println(group.toString());
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Wrong input");
            }
        }
    }

    public static void handleAddStudent(BufferedReader bufferedReader, Group group) throws Exception {
        String name = "";
        String input = "";
        double grade;
        while (true) {
            System.out.print("(add student menu) Enter name> ");
            input = bufferedReader.readLine();
            if (input.equals("help")) {
                System.out.println("You may only enter what is asked or 'exit' to exit");
                continue;
            } else if (input.equals("exit")) {
                return;
            } else {
                name = input;
                break;
            }
        }

        while (true) {
            System.out.print("(add student menu) Enter grade> ");
            input = bufferedReader.readLine();
            if (input.equals("help")) {
                System.out.println("You may only enter what is asked or 'exit' to exit");
                continue;
            } else if (input.equals("exit")) {
                return;
            } else {
                grade = Double.valueOf(input);
                break;
            }
        }

        group.addStudent(new Student(name, grade));

    }
}
