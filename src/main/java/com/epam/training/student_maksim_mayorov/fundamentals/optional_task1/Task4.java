package com.epam.training.student_maksim_mayorov.fundamentals.optional_task1;

import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

//      Задание. Ввести n чисел с консоли.
//      4. Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.print("Enter " + n + " numbers: ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        int minDifferentDigits = getNumberOfDifferentDigits(numbers[0]);
        int numberWithMinDifferentDigits = numbers[0];
        for (int number: numbers) {
            int numberOfDifferentDigits = getNumberOfDifferentDigits(number);
            if (numberOfDifferentDigits < minDifferentDigits) {
                minDifferentDigits = numberOfDifferentDigits;
                numberWithMinDifferentDigits = number;
            }
        }
        System.out.println("The number with the minimum number of different digits: " + numberWithMinDifferentDigits);

    }

    private static int getNumberOfDifferentDigits(int number) {
        int countDifferentDigits = 0;
        int[] digits = new int[10];
        while (number > 0) {
            digits[number % 10]++;
            number /= 10;
        }
        for (int digit: digits) {
            if (digit > 0) {
                countDifferentDigits++;
            }
        }
        return countDifferentDigits;
    }

}
