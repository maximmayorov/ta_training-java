package com.epam.training.student_maksim_mayorov.io.optional_task;

import com.epam.training.student_maksim_mayorov.io.optional_task.utils.FileProcessor;

import java.util.List;

public class Task2 {

    public static void main(String[] args) {

//        Задание. Выполнить указанные действия по чтению информации из файла, ее обработке и записи в файл.
//        При разработке для вывода результатов создавать новую директорию и файл средствами класса File.
//
//        2. Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.

        List<String> programCode = FileProcessor.readFile("data/javaProgram.txt");
        for (int i = 0; i < programCode.size(); i++) {
            programCode.set(i, programCode.get(i).replace("public", "private"));
        }
        FileProcessor.writeFile(programCode, "data/task2/javaProgram.txt");
    }
}
