package com.epam.training.student_maksim_mayorov.fundamentals.main_task;

import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {

        // 5. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the month number: ");
        int monthNumber = scanner.nextInt();
        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October",
                "November", "December"};
        if (monthNumber > 0 && monthNumber <= 12) {
            System.out.println(months[monthNumber - 1]);
        } else {
            System.out.println("Incorrect month number entry");
        }

    }
}
