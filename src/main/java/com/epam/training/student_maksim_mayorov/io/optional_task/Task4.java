package com.epam.training.student_maksim_mayorov.io.optional_task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task4 {

    public static void main(String[] args) {

//        Задание. Выполнить указанные действия по чтению информации из файла, ее обработке и записи в файл.
//        При разработке для вывода результатов создавать новую директорию и файл средствами класса File.
//
//        4. Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными.

        String file = "data/javaProgram.txt";
        List<String> programCode = readFile(file);
        for (int i = 0; i < programCode.size(); i++) {
            String[] words = programCode.get(i).split("\\s+");
            for (int j = 0; j < words.length; j++) {
                if (words[j].length() > 2) {
                    words[j] = words[j].toUpperCase();
                }
            }
            programCode.set(i, String.join(" ", words));
        }
        writeFile(programCode);
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
        String resultFile = "data/task4/javaProgram.txt";
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
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
