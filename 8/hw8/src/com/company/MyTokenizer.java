package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MyTokenizer {
    private String filename;
    private String delimiters;
    public MyTokenizer(String filename, String delimiters){
        this.filename = filename;
        this.delimiters = delimiters;
    }
    /*gets array of all words in file divided by delimiters and sorts array by alphabet so same words will be next each other*/
    public  String[] getTokenized(){
        FileReader fileReader = null;
        String[] array = new String[0];
        try {
            fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String s;
            while((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s);
            }
            StringTokenizer stringTokenizer = new StringTokenizer(stringBuilder.toString(), delimiters);
            array = new String[stringTokenizer.countTokens()];
            int i = 0;
            while(stringTokenizer.hasMoreTokens()) {
                array[i] = stringTokenizer.nextToken();
                i++;
            }
            Arrays.sort(array, Comparator.comparing(String::toString));
            System.out.println("Amount of words: "+array.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
}
