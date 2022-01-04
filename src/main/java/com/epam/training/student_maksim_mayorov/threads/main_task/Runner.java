package com.epam.training.student_maksim_mayorov.threads.main_task;

public class Runner {

    private static final int NUMBER_OF_CARS = 20;
    private static final int NUMBER_OF_AVAILABLE_PARKING_SPACES = 5;

    public static void main(String[] args) {

//        Разработать консольное многопоточное приложение.
//        Использовать возможности, предоставляемые пакетом java.util.concurrent.
//        Все сущности, желающие получить доступ к ресурсу, должны быть потоками.
//
//        2. Автостоянка. Доступно несколько машиномест. На одном месте может находиться только один автомобиль.
//        Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.

        Parking parking = new Parking(NUMBER_OF_AVAILABLE_PARKING_SPACES);
        System.out.println("Parking with " + NUMBER_OF_AVAILABLE_PARKING_SPACES + " free spaces");
        for (int i = 0; i < NUMBER_OF_CARS; i++) {
            new Car("Car" + i, parking).start();
        }
    }
}
