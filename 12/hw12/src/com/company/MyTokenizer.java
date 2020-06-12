package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class MyTokenizer {
    private Map<String, Map<String,Integer>> dictionary;
    private List<File> files;
    private String delimiters;
    private int totalWordsCount = 0;
    private boolean tokenized = false;

    public MyTokenizer(List<File> files, String delimiters) throws NoFilesException {
        if(files==null||files.size()==0){
            throw new NoFilesException();
        }
        this.files = files;
        this.delimiters = delimiters;
        dictionary = new HashMap<>();
    }

    public int getTotalWordsCount(){
        if(tokenized){
            return totalWordsCount;
        }else {
            return -1;
        }
    }

    public boolean getIsTokenized(){
        return tokenized;
    }

    public int getDictionarySize(){
        return dictionary.size();
    }

    public void tokenize() throws IOException {
        for(File file:files){
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String buff;
            while ((buff = bufferedReader.readLine())!=null){
                stringBuilder.append("\n"+buff+"\n");
            }
            StringTokenizer stringTokenizer = new StringTokenizer(stringBuilder.toString(),delimiters);
            String token;
            Map<String, Integer> fileToFrequency;
            while (stringTokenizer.hasMoreTokens()){
                totalWordsCount++;
                token = stringTokenizer.nextToken();
                if(dictionary.containsKey(token)){
                    fileToFrequency = dictionary.get(token);
                    if(fileToFrequency.containsKey(file.getName())){
                        fileToFrequency.put(file.getName(),fileToFrequency.get(file.getName())+1);
                    }else{
                        fileToFrequency.put(file.getName(),1);
                    }
                }else{
                    fileToFrequency = new HashMap<>();
                    fileToFrequency.put(file.getName(),1);
                    dictionary.put(token,fileToFrequency);
                }
            }
        }
        tokenized = true;
    }

    @Override
    public String toString() {
        return dictionary.toString().replace("}","}\n");
    }
}
