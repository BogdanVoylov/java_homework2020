package com.company;
/*Написати програму, що зчитує інформацію з текстового файлу і рахує кількість слів в файлі, кількість унікальних слів в файлі, виводить інформацію про кількість слів, кількість унікальних слів, унікальні слова за алфавітом і поруч скільки разів це слово зустрілося. Унікальні слова - це, так би мовити, словарний запас файлу. Тобто, якщо у вас у файлі сто слів, але при цьому там двадцять п'ять різних слів, кожне з яких повторюється чотири рази, то унікальних слів - 25.

Продумати ієрархію класів.*/

public class Main {

    public static void main(String[] args)  {
        MyTokenizer myTokenizer = new MyTokenizer("1.txt", " ?.,!;:'\"");
        Counter counter = new Counter(myTokenizer.getTokenized());
        System.out.println(counter.countUnique());
    }
}