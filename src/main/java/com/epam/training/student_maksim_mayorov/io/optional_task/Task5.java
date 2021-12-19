package com.epam.training.student_maksim_mayorov.io.optional_task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {

        // 5. В файле, содержащем фамилии студентов и их оценки, записать прописными буквами фамилии тех студентов, которые имеют средний балл более 7.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file to read: ");
        String file = scanner.next();
        List<String> students = readFile(file);
        for (int i = 0; i < students.size(); i++) {
            String[] words = students.get(i).split("\\s+");
            double sum = 0;
            for (int j = 1; j < words.length; j++) {
                sum += Integer.parseInt(words[j]);
            }
            if ((sum / (words.length - 1)) > 7) {
                words[0] = words[0].toUpperCase();
            }
            students.set(i, String.join(" ", words));
        }
        students.forEach(System.out::println);
        writeFile(students);
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

    private static void writeFile(List<String> lines) {
        String resultFile = "results/result.txt";
        File file = new File(resultFile);
        if (file.getParentFile().mkdirs()) {
            System.out.println("A directory with results has been created");
        }
        try {
            if (file.createNewFile()) {
                System.out.println("A file with results has been created");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (String string: lines) {
                writer.write(string);
                writer.newLine();
            }
            System.out.println("The result of the program was written in " + resultFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
