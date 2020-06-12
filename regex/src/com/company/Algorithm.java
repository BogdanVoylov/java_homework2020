package com.company;


import java.util.*;
import java.util.regex.*;

public class Algorithm {
    private ArrayList <Rule> base;

    public Algorithm (String allRules){
        allRules = allRules.replaceAll(" ","");
        if(allRules.charAt(allRules.length()-1)!=';'){
            allRules+=";";
        }
        Pattern pattern = Pattern.compile("^(([a-zA-Z]|#)*(->|->\\.)([a-zA-Z]|#)*;)*$");
        Matcher matcher = pattern.matcher(allRules);
        if(!matcher.find()){
            base = null;
            return;
        }else {
            base = new ArrayList<Rule>();
        }
        String[] splitedRules = allRules.split(";");
        for(String rule:splitedRules){
            String[] beginEnd = rule.split("->");
            if(beginEnd[1].charAt(0)=='.'){
                base.add(new Rule(Pattern.compile(beginEnd[0]),beginEnd[1].substring(1),true));
            }else{
                base.add(new Rule(Pattern.compile(beginEnd[0]),beginEnd[1],false));
            }
        }
    }

    public String eval(String input, int cnt){
        int i = 0;
        for(; i < cnt; i++) {
            for (Rule rule : base) {
                if(rule.left.matcher(input).find()){
                    input = input.replaceFirst(rule.left.pattern(),rule.right);
                    if(rule.end){
                        return input;
                    }
                    break;
                }
            }
        }
        if(i>=cnt){
            return "undefined";
        }else {
            return input;
        }
    }
    public boolean isGood(){ return base != null;}
    private class Rule {
        Pattern left;
        String right;
        boolean end;
        Rule (Pattern sl, String sr, boolean end){
            this.left=sl; this.right= sr; this.end=end;
        }
        @Override
        public String toString() {
            return left + " ->" + (end?".":"") + " " + right;
        }
    }
    // .... methods
    // ......
    // ......
    @Override
    public String toString() {
        String res="";
        if (base==null) res = "Error Algorithm";
        else {
            res= "Algorithm = [";
            for(int i=0; i<base.size();i++ )
                res += "  \n " + base.get(i).toString();
            res += "]";
        }
        return res;
    }
}

