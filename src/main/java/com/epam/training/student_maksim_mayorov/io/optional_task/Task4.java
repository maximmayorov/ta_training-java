package com.epam.training.student_maksim_mayorov.io.optional_task;

import com.epam.training.student_maksim_mayorov.io.optional_task.utils.FileProcessor;

import java.util.List;

public class Task4 {

    public static void main(String[] args) {

//        Задание. Выполнить указанные действия по чтению информации из файла, ее обработке и записи в файл.
//        При разработке для вывода результатов создавать новую директорию и файл средствами класса File.
//
//        4. Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными.

        List<String> programCode = FileProcessor.readFile("data/javaProgram.txt");
        for (int i = 0; i < programCode.size(); i++) {
            String[] words = programCode.get(i).split("\\s+");
            for (int j = 0; j < words.length; j++) {
                if (words[j].length() > 2) {
                    words[j] = words[j].toUpperCase();
                }
            }
            programCode.set(i, String.join(" ", words));
        }
        FileProcessor.writeFile(programCode, "data/task4/javaProgram.txt");
    }
}
