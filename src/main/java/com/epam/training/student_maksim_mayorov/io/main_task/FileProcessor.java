package com.epam.training.student_maksim_mayorov.io.main_task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    public static final String FOLDER_PREFIX = "-----";

    public static List<String> readDirectory(File directory, int level) {
        List<String> filesList = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File item : files) {
                if (item.isDirectory()) {
                    filesList.add("\t|" + "\t\t|".repeat(level) + FOLDER_PREFIX + item.getName());
                    filesList.addAll(readDirectory(item, level + 1));
                } else {
                    filesList.add("\t" + "|\t\t".repeat(level) + item.getName());
                }
            }
        }
        return filesList;
    }

    public static void writeFile(List<String> lines, String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String string: lines) {
                writer.write(string);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
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
