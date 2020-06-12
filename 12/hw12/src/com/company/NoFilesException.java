package com.company;

public class NoFilesException extends Exception{
    NoFilesException(){
        super("Expected at least one file in list");
    }
}
