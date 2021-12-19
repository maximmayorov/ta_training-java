package com.epam.training.student_maksim_mayorov.collections.optional_task;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        // 1. Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file name to read: ");
        String file = scanner.next();
        List<String> lines = readFileLines(file);
        System.out.println("Lines from file " + file);
        lines.forEach(System.out::println);
        Collections.reverse(lines);
        writeFileLines(lines, file);
    }

    private static List<String> readFileLines(String file) {
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

    private static void writeFileLines(List<String> lines, String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String string: lines) {
                writer.write(string);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
