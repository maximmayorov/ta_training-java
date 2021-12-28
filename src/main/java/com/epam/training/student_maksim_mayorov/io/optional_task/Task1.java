package com.epam.training.student_maksim_mayorov.io.optional_task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Task1 {

    public static void main(String[] args) {

//        Задание. Выполнить указанные действия по чтению информации из файла, ее обработке и записи в файл.
//        При разработке для вывода результатов создавать новую директорию и файл средствами класса File.
//
//        1. Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.

        String resultFile = "results/result.txt";
        Random random = new Random();
        int[] randomNumbers = random.ints(10, -1000, 1000).toArray();
        Arrays.sort(randomNumbers);
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
        try (FileWriter writer = new FileWriter(file, false)) {
            for (int number: randomNumbers) {
                writer.write(number + " ");
            }
            System.out.println("The result of the program was written in " + resultFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
