package com.epam.training.student_maksim_mayorov.fundamentals.optional_task1;

import java.util.Scanner;

public class Task7 {

    public static void main(String[] args) {

//      Задание. Ввести n чисел с консоли.
//      7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.print("Enter " + n + " numbers: ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int number: numbers) {
            if (isDifferentDigits(number)) {
                System.out.println("A number consisting only of different digits: " + number);
                break;
            }
        }
    }

    private static boolean isDifferentDigits(int number) {
        int[] digits = new int[10];
        while (number > 0) {
            int digitIndex = number % 10;
            digits[digitIndex]++;
            if (digits[digitIndex] > 1) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}
