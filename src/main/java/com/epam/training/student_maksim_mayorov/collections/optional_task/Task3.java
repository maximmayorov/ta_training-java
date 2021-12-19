package com.epam.training.student_maksim_mayorov.collections.optional_task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        // 3. Создать список из элементов каталога и его подкаталогов.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a directory name to read: ");
        String directory = scanner.next();
        File dir = new File(directory);
        if (dir.exists() && dir.isDirectory()) {
            readDirectory(dir).forEach(System.out::println);
        } else {
            System.out.println(directory + "is not a directory");
        }

    }

    private static List<String> readDirectory(File dir) {
        List<String> filesList = new ArrayList<>();
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    filesList.add(file.getName());
                } else {
                    filesList.addAll(readDirectory(file));
                }
            }
        }
        return filesList;
    }
}
