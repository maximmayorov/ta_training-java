package com.epam.training.student_maksim_mayorov.io.optional_task.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    public static List<String> readFile(String file) {
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

    public static void writeFile(List<String> lines, String resultFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(createFolderAndFile(resultFile)))) {
            for (String string: lines) {
                writer.write(string);
                writer.newLine();
            }
            System.out.println("The result of the program was written in " + resultFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(int[] array, String resultFile) {
        try (FileWriter writer = new FileWriter(createFolderAndFile(resultFile))) {
            for (int element: array) {
                writer.write(element + " ");
            }
            System.out.println("The result of the program was written in " + resultFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File createFolderAndFile(String resultFile) {
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
        return file;
    }
}
