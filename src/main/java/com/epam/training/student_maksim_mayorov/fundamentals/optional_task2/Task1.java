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
        sortByRows(matrix);
        System.out.println("\nMatrix with ordered rows: ");
        printMatrix(matrix);
        sortByColumns(matrix);
        System.out.println("\nMatrix with ordered columns: ");
        printMatrix(matrix);

    }

    private static void sortByRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            boolean sorted = false;
            while (!sorted) {
                sorted = true;
                for (int j = 0; j < matrix.length - 1; j++) {
                    if (matrix[i][j] > matrix[i][j + 1]) {
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[i][j + 1];
                        matrix[i][j + 1] = temp;
                        sorted = false;
                    }
                }
            }
        }
    }

    private static void sortByColumns(int[][] matrix) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length - 1; j++) {
                    if (matrix[j][i] > matrix[j + 1][i]) {
                        int temp = matrix[j][i];
                        matrix[j][i] = matrix[j + 1][i];
                        matrix[j + 1][i] = temp;
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
