package com.epam.training.student_maksim_mayorov.io.main_task;

import java.io.File;
import java.util.List;

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
        File file = new File(args[0]);
        if (file.exists()) {
            if (file.isFile()) {
                DirectoryStructureReader directoryStructureReader = new DirectoryStructureReader(args[0]);
                System.out.println("Number of folders: " + directoryStructureReader.getNumberOfFolders());
                System.out.println("Number of files: " + directoryStructureReader.getNumberOfFiles());
                System.out.println("Average number of files per folder: " + directoryStructureReader.getAverageNumberFilesInFolder());
                System.out.println("Average file name length: " + directoryStructureReader.getAverageFileNameLength());
            } else {
                String outputFile = "data/directoryStructure.txt";
                List<String> directoryLines = FileProcessor.readDirectory(file, 0);
                directoryLines.add(0, file.getName());
                System.out.println("The file and folder structure of the " + args[0] +" directory will be written to " + outputFile);
                FileProcessor.writeFile(directoryLines, outputFile);
            }
        } else {
            System.out.println("Directory or file doesn't exist");
        }
    }
}
