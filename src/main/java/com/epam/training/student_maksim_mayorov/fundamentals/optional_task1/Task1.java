package com.epam.training.student_maksim_mayorov.fundamentals.optional_task1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

//      Задание. Ввести n чисел с консоли.
//      1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.print("Enter " + n + " numbers: ");
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.next();
        }
        String shortNumber = numbers[0];
        String longNumber = "";
        for (String number: numbers) {
            if (number.length() > longNumber.length()){
                longNumber= number;
            }
            if (number.length() < shortNumber.length()) {
                shortNumber = number;
            }
        }
        System.out.println("Short number is: " + shortNumber + "\this length is: " + shortNumber.length());
        System.out.println("Long number is: " + longNumber + "\this length is: " + longNumber.length());

    }
}
