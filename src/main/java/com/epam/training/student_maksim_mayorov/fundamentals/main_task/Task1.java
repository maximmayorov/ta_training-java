package com.epam.training.student_maksim_mayorov.fundamentals.main_task;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        // 1. Приветствовать любого пользователя при вводе его имени через командную строку.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String userName = scanner.next();
        System.out.println("Hello " + userName);

    }
}
