package com.company;

public class Counter {
    public String[] array;
    public Counter(String[] array){
        this.array = array;
    }
    /*array was sorted so it(script) checks whether nearby words equals and if not it begins counting again.
     * Next time it finds not equal words it will add previous word to res with times it was found in array*/
    public String countUnique(){
        String currentWord = "";
        int currentCount = 1;
        String res = "";
        for (int i = 0; i < array.length;i++){
            if(!array[i].equals(currentWord)){
                if(i>0){
                    res+=currentWord+":"+currentCount+"\n";
                    currentCount=1;
                }
                currentWord = array[i];
            }else{
                currentCount++;
            }
        }
        return res;
    }
}
