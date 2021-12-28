package com.epam.training.student_maksim_mayorov.io.optional_task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) {

        // 2. Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file name to read: ");
        String inputFile = scanner.next();
        List<String> programCode = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            programCode = reader.lines().map(s -> s.replace("public", "private")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeFile(programCode);
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
