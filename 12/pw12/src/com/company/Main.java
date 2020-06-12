package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        // write your code here
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (true) {
            System.out.print("Enter date > ");
            try {
                input = bufferedReader.readLine();
                System.out.println("Your date is:" + new Date(input).toString());
            } catch (MyException | IOException e) {
                e.printStackTrace();
                System.out.println();
            }
        }

    }
}
