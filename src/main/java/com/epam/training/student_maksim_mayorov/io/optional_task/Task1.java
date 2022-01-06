package com.epam.training.student_maksim_mayorov.io.optional_task;

import com.epam.training.student_maksim_mayorov.io.optional_task.utils.FileProcessor;

import java.util.Arrays;
import java.util.Random;

public class Task1 {

    public static void main(String[] args) {

//        Задание. Выполнить указанные действия по чтению информации из файла, ее обработке и записи в файл.
//        При разработке для вывода результатов создавать новую директорию и файл средствами класса File.
//
//        1. Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.

        Random random = new Random();
        int[] randomNumbers = random.ints(10, -1000, 1000).toArray();
        Arrays.sort(randomNumbers);
        FileProcessor.writeFile(randomNumbers, "data/task1/randomNumbers.txt");
    }
}
