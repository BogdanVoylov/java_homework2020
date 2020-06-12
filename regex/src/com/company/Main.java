package com.company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println(onlyOdd("aabbb"));
        System.out.println(onlyOdd("abbb"));
        System.out.println(isIden("4_5"));
        System.out.println(isIden("d_5"));
        System.out.println(cntIden("8_5rff;hgh"));
        System.out.println(distIden("8_5rff;hgh"));
        System.out.println("212.00045 , +32.333 , -5454.6767");
        Algorithm algorithm = new Algorithm("a->b;b->.c");
        System.out.println(algorithm.eval("aabab",100));
    }

    public static boolean onlyOdd(String str) {
        int countA = (str.split("a", -1).length) - 1;
        int countB = (str.split("b", -1).length) - 1;
        if (countA % 2 != 0 && countB % 2 != 0 && countA + countB == str.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isIden(String str){
        Pattern pattern = Pattern.compile("^[a-zA-Z]([a-zA-Z]*(_)*[0-9]*)*$");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static int cntIden(String str){
        Pattern pattern = Pattern.compile("([a-zA-Z]([a-zA-Z]*(_)*[0-9]*)*)");
        Matcher matcher = pattern.matcher(str);
        int res = 0;
        while (matcher.find()){
            res++;
        }
        return res;
    }

    public static int distIden(String str){
        Pattern pattern = Pattern.compile("([a-zA-Z]([a-zA-Z]*(_)*[0-9]*)*)");
        Matcher matcher = pattern.matcher(str);
        ArrayList<String> stringArrayList = new ArrayList<String>();
        while (matcher.find()){
            stringArrayList.add(str.substring(matcher.start(),matcher.end()));
        }
        int res = (int)stringArrayList.stream().distinct().count();
        return res;
    }
    public static Double sumDouble(String str){
        Double res = 0d;
        Pattern pattern = Pattern.compile("^((\\s)*((\\d{3}\\.\\d{5})|(\\+\\d{2}\\.\\d{3})|(-\\d{4}\\.\\d{4}))(\\s)*(,(\\s)*((\\d{3}\\.\\d{5})|(\\+\\d{2}\\.\\d{3})|(\\-\\d{4}\\.\\d{4}))(\\s)*)*)$");
        Matcher matcher = pattern.matcher(str);
        if(!matcher.find()){
            return null;
        }else{
            Pattern pattern1 = Pattern.compile("(\\d{3}\\.\\d{5})");
            matcher = pattern1.matcher(str);
            while (matcher.find()){
                res+=Double.valueOf(str.substring(matcher.start(),matcher.end()));
            }

            Pattern pattern2 = Pattern.compile("(\\+\\d{2}\\.\\d{3})");
            matcher = pattern2.matcher(str);
            while (matcher.find()){
                res+=Double.valueOf(str.substring(matcher.start()+1,matcher.end()));
            }

            Pattern pattern3 = Pattern.compile("(\\-\\d{4}\\.\\d{4})");
            matcher = pattern3.matcher(str);
            while (matcher.find()){
                res-=Double.valueOf(str.substring(matcher.start()+1,matcher.end()));
            }
        }
        return res;
    }
}
