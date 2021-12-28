package com.epam.training.student_maksim_mayorov.fundamentals.main_task;

public class Task2 {

    public static void main(String[] args) {

        // 2. Отобразить в окне консоли аргументы командной строки в обратном порядке.

        if (args.length == 0) {
            System.out.println("No command line arguments!");
            return;
        }

        System.out.println("Command line arguments in reverse order:");
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println("Argument -> " + args[i]);
        }

    }
}
