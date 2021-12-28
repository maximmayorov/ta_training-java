package com.epam.training.student_maksim_mayorov.collections.optional_task;

import java.util.Scanner;
import java.util.Stack;

public class Task2 {

    public static void main(String[] args) {

        // 2. Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.

        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        char[] numberArray = String.valueOf(number).toCharArray();
        for (char num: numberArray) {
            stack.push(num);
        }
        System.out.print("Number in reverse order: ");
        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }
}
