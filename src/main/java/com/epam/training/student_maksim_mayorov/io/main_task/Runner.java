package com.epam.training.student_maksim_mayorov.io.main_task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

//        Реализовать программу которая будет получать в качестве аргумента командной строки путь к директории, например "D:/movies".
//        Записать в текстовый файл структуру папок и файлов в виде, похожем на выполнение программы tree /F.
//
//        Если в качестве параметра в программу передается не путь к директории,
//        а путь к txt файлу по образцу выше - прочитать файл и вывести в консоль следующие данные:
//
//        Количество папок
//        Количество файлов
//        Среднее количество файлов в папке
//        Среднюю длинну названия файла

        if (args.length == 0) {
            System.out.println("No command line arguments with directory name or file name");
            return;
        }
        String fileName = args[0];
        File root = new File(fileName);
        if (root.exists()) {
            if (root.isFile()) {
                FileTreeReader fileTreeReader = new FileTreeReader(fileName);
                System.out.println("Number of folders: " + fileTreeReader.getNumberOfFolders());
                System.out.println("Number of files: " + fileTreeReader.getNumberOfFiles());
                System.out.println("Average number of files per folder: " + fileTreeReader.getAverageNumberFilesInFolder());
                System.out.println("Average file name length: " + fileTreeReader.getAverageFileNameLength());
            } else {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a filename to writing the structure of folders and files: ");
                String file = scanner.next();
                List<String> directoryList = new ArrayList<>();
                directoryList.add(root.getName());
                directoryList.addAll(readDirectory(root, 0));
                writeFile(directoryList, file);
            }
        }
    }

    private static List<String> readDirectory(File directory, int level) {
        List<String> filesList = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    filesList.add("\t|" + "\t\t|".repeat(level) + FileTreeReader.FOLDER_PREFIX + file.getName());
                    filesList.addAll(readDirectory(file, level + 1));
                    filesList.add("\t|" + "\t\t".repeat(level));
                } else {
                    filesList.add("\t" + "|\t\t".repeat(level) + file.getName());
                }
            }
        }
        return filesList;
    }

    private static void writeFile(List<String> lines, String file) {
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
