package com.company;

import java.util.Iterator;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.push("1");
        myLinkedList.push("2");
        myLinkedList.push("3");
        myLinkedList.removeFirst();
        System.out.println(myLinkedList.getLast());
    }
}
