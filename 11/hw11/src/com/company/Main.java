package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
Зробити графічний інтерфейс (за бажанням).

Написати програму, що по заданій колекції текстових файлів будує словник термінів і до кожного терміну ставить у відповідність інвертований список документів з частотою терміна в документі.

Текстові файли подаються на вхід в будь-якому текстовому форматі.
Розмір текстових файлів не менше 150 К.
Кількість текстових файлів не менше 10.
Словник термінів зберегти на диск.
Оцінити розмір колекції, загальну кількість слів в колекції та розмір словника.*/
public class Main {

    public static void main(String[] args) {
        List<File> files = new ArrayList<>();
        files.add(new File("1.txt"));
        files.add(new File("2.txt"));
        files.add(new File("3.txt"));
        files.add(new File("4.txt"));
        files.add(new File("5.txt"));
        files.add(new File("6.txt"));
        files.add(new File("7.txt"));
        files.add(new File("8.txt"));
        files.add(new File("9.txt"));
        files.add(new File("10.txt"));
        MyTokenizer tokenizer = new MyTokenizer(files," ?.,!;:'\\\""+System.lineSeparator());
        try {
            tokenizer.tokenize();
            FileWriter fileWriter = new FileWriter(new File("res.txt"));
            fileWriter.write(tokenizer.toString());
            System.out.println("Collection size:"+tokenizer.getTotalWordsCount());
            System.out.println("Dictionary size:"+tokenizer.getDictionarySize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
