package com.epam.training.student_maksim_mayorov.io.optional_task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) {

//        Задание. Выполнить указанные действия по чтению информации из файла, ее обработке и записи в файл.
//        При разработке для вывода результатов создавать новую директорию и файл средствами класса File.
//
//        2. Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.

        List<String> programCode = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/javaProgram.txt"))) {
            programCode = reader.lines().map(s -> s.replace("public", "private")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeFile(programCode);
    }

    private static void writeFile(List<String> lines) {
        String resultFile = "data/task2/javaProgram.txt";
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
