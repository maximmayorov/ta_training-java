package com.epam.training.student_maksim_mayorov.fundamentals.optional_task1;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

//        Задание. Ввести n чисел с консоли.
//        3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.print("Enter " + n + " numbers: ");
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.next();
        }
        int averageLength = 0;
        for (String number: numbers) {
            averageLength += number.length();
        }
        averageLength /= numbers.length;
        System.out.println("Average number length: " + averageLength);
        System.out.println("Numbers whose length is less than the average length for all numbers:");
        for (String number: numbers) {
            if (number.length() < averageLength) {
                System.out.println(number + " his length: " + number.length());
            }
        }
        System.out.println("Numbers whose length is greater than the average length for all numbers:");
        for (String number: numbers) {
            if (number.length() > averageLength) {
                System.out.println(number + " his length: " + number.length());
            }
        }

    }
}
