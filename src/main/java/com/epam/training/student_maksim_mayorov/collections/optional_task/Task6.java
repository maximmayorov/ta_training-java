package com.epam.training.student_maksim_mayorov.collections.optional_task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task6 {

    public static void main(String[] args) {

        // 6. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.

        List<String> lines = readFile("data/data2.txt");
        Collections.sort(lines, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // Sorting in ascending order of string length
                return o1.length() - o2.length();
            }
        });
        lines.forEach(System.out::println);
    }

    private static List<String> readFile(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
