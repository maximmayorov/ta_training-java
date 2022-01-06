package com.epam.training.student_maksim_mayorov.io.optional_task;

import com.epam.training.student_maksim_mayorov.io.optional_task.utils.FileProcessor;

import java.util.List;

public class Task3 {

    public static void main(String[] args) {

//        Задание. Выполнить указанные действия по чтению информации из файла, ее обработке и записи в файл.
//        При разработке для вывода результатов создавать новую директорию и файл средствами класса File.
//
//        3. Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.

        List<String> programCode = FileProcessor.readFile("data/javaProgram.txt");
        for (int i = 0; i < programCode.size(); i++) {
            programCode.set(i, new StringBuilder().append(programCode.get(i)).reverse().toString());
        }
        FileProcessor.writeFile(programCode, "data/task3/reverseJavaProgram.txt");
    }
}
