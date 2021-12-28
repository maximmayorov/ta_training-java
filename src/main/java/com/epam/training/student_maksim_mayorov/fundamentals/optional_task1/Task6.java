package com.epam.training.student_maksim_mayorov.fundamentals.optional_task1;

import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) {

//      Задание. Ввести n чисел с консоли.
//      6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.print("Enter " + n + " numbers: ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int number: numbers) {
            if (isDigitsAscending(number)) {
                System.out.println("Number in which the digits are in strict ascending order: " + number);
                break;
            }
        }

    }

    private static boolean isDigitsAscending(int number) {
        int lastDigit = number % 10;
        number /= 10;
        while (number > 0) {
            if (number % 10 >= lastDigit) {
                return false;
            }
            lastDigit = number % 10;
            number /= 10;
        }
        return true;
    }
}
