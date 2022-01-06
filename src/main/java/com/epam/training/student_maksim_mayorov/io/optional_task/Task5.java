package com.epam.training.student_maksim_mayorov.io.optional_task;

import com.epam.training.student_maksim_mayorov.io.optional_task.utils.FileProcessor;

import java.util.List;

public class Task5 {

    public static void main(String[] args) {

//        Задание. Выполнить указанные действия по чтению информации из файла, ее обработке и записи в файл.
//        При разработке для вывода результатов создавать новую директорию и файл средствами класса File.
//
//        5. В файле, содержащем фамилии студентов и их оценки, записать прописными буквами фамилии тех студентов, которые имеют средний балл более 7.

        List<String> students = FileProcessor.readFile("data/students.txt");
        for (int i = 0; i < students.size(); i++) {
            String[] words = students.get(i).split("\\s+");
            double sum = 0;
            for (int j = 1; j < words.length; j++) {
                sum += Integer.parseInt(words[j]);
            }
            if ((sum / (words.length - 1)) > 7) {
                words[0] = words[0].toUpperCase();
            }
            students.set(i, String.join(" ", words));
        }
        FileProcessor.writeFile(students, "data/task5/students.txt");
    }
}
