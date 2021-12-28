package com.epam.training.student_maksim_mayorov.fundamentals.optional_task2;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Task4 {

    public static void main(String[] args) {

//      Ввести с консоли n - размерность матрицы a [n] [n].
//      Задать значения элементов матрицы в интервале значений от -M до M с помощью генератора случайных чисел (класс Random).
//      4. Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие

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
        int maxElement = matrix[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                }
            }
        }
        System.out.println("Max element: " + maxElement);
        System.out.println("Matrix in which the rows and columns containing the maximum element have been removed: ");
        printMatrix(removeRowsAndColumnsWithMaxElement(matrix, maxElement));

    }

    private static int[][] removeRowsAndColumnsWithMaxElement(int[][] matrix, int maxElement) {
        Set<Integer> deleteRows = new HashSet<>();
        Set<Integer> deleteColumns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == maxElement) {
                    deleteRows.add(j);
                    deleteColumns.add(i);
                }
            }
        }
        int[][] newMatrix = new int[matrix.length - deleteColumns.size()][matrix[0].length - deleteRows.size()];
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (deleteColumns.contains(i)) {
                continue;
            }
            int l = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (deleteRows.contains(j)) {
                    continue;
                }
                newMatrix[k][l] = matrix[i][j];
                l++;
            }
            k++;
        }
        return newMatrix;
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
