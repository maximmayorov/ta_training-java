package com.epam.training.student_maksim_mayorov.fundamentals.main_task;

import java.util.Random;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        // 3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int min = -1000;
        int max = 1000;
        System.out.print("Enter the number of random numbers: ");
        int number = scanner.nextInt();
        System.out.println("Random numbers with a new line:");
        for (int i = 0; i < number; i++) {
            System.out.println(random.nextInt(max - min) + min);
        }
        System.out.println("Random numbers without line breaks:");
        for (int i = 0; i < number; i++) {
            System.out.print(random.nextInt(max - min) + min + " ");
        }

    }
}
