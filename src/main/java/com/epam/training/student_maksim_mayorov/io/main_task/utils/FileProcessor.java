package com.epam.training.student_maksim_mayorov.io.main_task.utils;

import com.epam.training.student_maksim_mayorov.io.main_task.utils.constants.GlobalConstants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    public static void processDirectory(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isFile()) {
                DirectoryStructureReader directoryStructureReader = new DirectoryStructureReader(path);
                System.out.println("Number of folders: " + directoryStructureReader.getNumberOfFolders());
                System.out.println("Number of files: " + directoryStructureReader.getNumberOfFiles());
                System.out.println("Average number of files per folder: " + directoryStructureReader.getAverageNumberFilesInFolder());
                System.out.println("Average file name length: " + directoryStructureReader.getAverageFileNameLength());
            } else {
                String outputFile = "data/directoryStructure.txt";
                List<String> directoryLines = FileProcessor.readDirectory(file, 0);
                directoryLines.add(0, file.getName());
                System.out.println("The file and folder structure of the " + path +" directory will be written to " + outputFile);
                FileProcessor.writeFile(directoryLines, outputFile);
            }
        } else {
            System.out.println("Directory or file doesn't exist");
        }
    }

    public static List<String> readDirectory(File directory, int level) {
        List<String> filesList = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File item : files) {
                if (item.isDirectory()) {
                    filesList.add("\t|" + "\t\t|".repeat(level) + GlobalConstants.FOLDER_PREFIX + item.getName());
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
