package com.epam.training.student_maksim_mayorov.io.main_task;

import com.epam.training.student_maksim_mayorov.io.main_task.utils.FileProcessor;

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
        FileProcessor.processDirectory(args[0]);
    }
}
