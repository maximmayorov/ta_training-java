package com.epam.training.student_maksim_mayorov.fundamentals.optional_task1;

import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {

//      Задание. Ввести n чисел с консоли.
//      5. Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.print("Enter " + n + " numbers: ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        int evenNumbers = 0;
        int evenOddNumbers = 0;
        for (int number: numbers) {

            int evenCount = 0;
            int oddCount = 0;
            while (number > 0) {
                if ((number % 10) % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
                number /= 10;
            }

            if (oddCount == 0) {
                evenNumbers++;
            }

            if (evenCount == oddCount) {
                evenOddNumbers++;
            }
        }
        System.out.println("Numbers with even digits only: " + evenNumbers);
        System.out.println("Numbers with equal numbers of even and odd digits among the remaining ones: " + evenOddNumbers);

    }
}
