package com.epam.training.student_maksim_mayorov.fundamentals.optional_task1;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

//      Задание. Ввести n чисел с консоли.
//      2. Вывести числа в порядке возрастания (убывания) значений их длины.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.print("Enter " + n + " numbers: ");
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.next();
        }
        bubbleSort(numbers);
        System.out.print("The numbers are sorted in ascending order of their length: ");
        printArray(numbers);
        reverseArray(numbers);
        System.out.print("The numbers are sorted in descending order of their length: ");
        printArray(numbers);

    }

    private static void bubbleSort(String[] array) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].length() > array[i + 1].length()) {
                    String temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    private static void reverseArray(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    private static void printArray(String[] array) {
        for (String element: array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
