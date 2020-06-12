package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(String string) throws MyException {
        Matcher matcher = Pattern.compile("^(\\d+)\\-(\\d+)\\-(\\d+)$").matcher(string);
        if(matcher.find()){
            int day = Integer.valueOf(matcher.group(1));
            int month = Integer.valueOf(matcher.group(2));
            int year = Integer.valueOf(matcher.group(3));
            if (
                    day < 0 || day > 31 ||
                    month < 0 || month > 12 ||
                    year < 0
            ) {
                throw new MyException();
            }
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new MyException();
        }
    }

    @Override
    public String toString() {
        return day + "-" + month + "-" + year;
    }
}
