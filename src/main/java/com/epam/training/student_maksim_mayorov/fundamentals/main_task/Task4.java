package com.epam.training.student_maksim_mayorov.fundamentals.main_task;

public class Task4 {

    public static void main(String[] args) {

        // 4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.

        if (args.length == 0) {
            System.out.println("No command line arguments");
            return;
        }

        int sum = 0;
        int product = 1;
        for (String arg : args) {
            sum += Integer.parseInt(arg);
            product *= Integer.parseInt(arg);
        }
        System.out.println("Sum of arguments: " + sum);
        System.out.println("Product of arguments: " + product);

    }
}
