package com.epam.training.student_maksim_mayorov.fundamentals.optional_task2;

import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

//       Ввести с консоли n - размерность матрицы a [n] [n].
//       Задать значения элементов матрицы в интервале значений от -M до M с помощью генератора случайных чисел (класс Random).
//       1.Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).

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
        System.out.print("Enter the column number relative to which to sort the rows: ");
        int k = scanner.nextInt();
        sortRowsByColumnValue(matrix, k - 1);
        System.out.println("\nMatrix with ordered rows relative to " + k +" column: ");
        printMatrix(matrix);
        System.out.print("Enter the row number relative to which to sort the columns: ");
        k = scanner.nextInt();
        sortColumnsByRowsValue(matrix, k - 1);
        System.out.println("\nMatrix with ordered columns relative to " + k + " row: ");
        printMatrix(matrix);
    }

    private static void sortRowsByColumnValue(int[][] matrix, int k) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < matrix.length; i++) {
               if (matrix[i][k] < matrix[i - 1][k]) {
                   int[] temp = matrix[i];
                   matrix[i] = matrix[i - 1];
                   matrix[i - 1] = temp;
               }
            }
        }
    }

    private static void sortColumnsByRowsValue(int[][] matrix, int k) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < matrix.length - 1; i++) {
                if (matrix[k][i] > matrix[k][i + 1]) {
                    for (int j = 0; j < matrix.length; j++) {
                        int temp = matrix[j][i];
                        matrix[j][i] = matrix[j][i + 1];
                        matrix[j][i + 1] = temp;
                        sorted = false;
                    }
                }
            }
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
