package com.epam.training.student_maksim_mayorov.threads.optional_task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Runner {

    private static final int RUNWAYS_NUMBER = 5;
    private static final int PLANES_NUMBER = 10;

    public static void main(String[] args) {

//        В аэропорту есть 5 взлетно-посадочных полос. Самолету требуется 3 минуты чтобы выйти на полосу, набрать скорость и взлететь.
//        После этого полоса свободна для вылета следующего самолета.
//        Реализовать симуляцию вылета 10 самолетов используя все доступные полосы. 1 минуту реально времени заменить на 1 секунду в симуляции.
//        Вывести в консоль информацию о следующих событиях:
//
//        Самолет начал выход на полосу
//        Самолет взлетел
//        Полоса "приняла" самолет
//        Полоса освободилась

        BlockingQueue<Runway> runways  = new ArrayBlockingQueue<>(RUNWAYS_NUMBER, true);
        for (int i = 0; i < RUNWAYS_NUMBER; i++) {
            runways.add(new Runway("Runway" + (i + 1)));
        }

        for (int i = 0; i < PLANES_NUMBER; i++) {
            new Plane("Plane" + (i + 1), runways).start();
        }
    }
}
