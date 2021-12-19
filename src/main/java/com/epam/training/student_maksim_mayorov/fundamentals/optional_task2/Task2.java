package com.epam.training.student_maksim_mayorov.fundamentals.optional_task2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

//      Ввести с консоли n - размерность матрицы a [n] [n].
//      Задать значения элементов матрицы в интервале значений от -M до M с помощью генератора случайных чисел (класс Random).
//      2. Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.

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
        printSequences(matrix);

    }

    private static void printSequences(int[][] matrix) {

        // Converting a matrix to a one-dimensional array
        int [] matrixArray = new int[matrix.length * matrix[0].length];
        int matrixIndex = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                matrixArray[matrixIndex++] = element;
            }
        }
        int tempInc = 0;
        int tempDec = 0;
        int incSize = 0;
        int decSize = 0;
        int indexInc = 0;
        int indexDec = 0;

        // Finding the largest number of increasing (decreasing) matrix elements in a row
        for (int i = 0; i < matrixArray.length - 1; i++) {
            if (matrixArray[i] < matrixArray[i + 1]) {
                tempInc++;
                if (tempInc > incSize) {
                    incSize = tempInc;
                    indexInc = i + 1;
                }
            } else {
                tempInc = 0;
            }

            if (matrixArray[i] > matrixArray[i + 1]) {
                tempDec++;
                if (tempDec > decSize) {
                    decSize = tempDec;
                    indexDec = i + 1;
                }
            } else {
                tempDec = 0;
            }
        }

        // Copying sequences from a matrix array and printing them
        int []incSequence = new int[incSize + 1];
        int []decSequence = new int[decSize + 1];
        System.arraycopy(matrixArray, indexInc - incSize, incSequence, 0, incSize + 1);
        System.out.println("\nThe largest increasing sequence of elements in the matrix: " + Arrays.toString(incSequence));
        System.arraycopy(matrixArray, indexDec - decSize, decSequence, 0, decSize + 1);
        System.out.println("The largest decreasing sequence of elements in the matrix: " + Arrays.toString(decSequence));

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
