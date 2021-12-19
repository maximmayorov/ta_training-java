package com.epam.training.student_maksim_mayorov.fundamentals.optional_task2;

import java.util.Random;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

//      Ввести с консоли n - размерность матрицы a [n] [n].
//      Задать значения элементов матрицы в интервале значений от -M до M с помощью генератора случайных чисел (класс Random).
//      3. Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter matrix size (n): ");
        int n = scanner.nextInt();
        System.out.print("Enter range of matrix values (M): ");
        int m = scanner.nextInt();
        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            matrix[i] = random.ints(n, -m, m).toArray();
        }
        System.out.println("\nSource matrix:");
        printMatrix(matrix);
        for (int i = 0; i < n; i++) {
            boolean firstPositive = false;
            int firstPositiveId = 0;
            int secondPositiveId = 0;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0) {
                    if (!firstPositive) {
                        firstPositiveId = secondPositiveId = j;
                        firstPositive = true;
                    } else {
                        secondPositiveId = j;
                        break;
                    }
                }
            }
            for (int k = firstPositiveId + 1; k < secondPositiveId; k++) {
                sum += matrix[i][k];
            }
            System.out.println("The sum of elements between the first and the second positive elements of the "+ (i + 1) + " row: " + sum);
        }

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}
