package com.epam.training.student_maksim_mayorov.threads.main_task;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {

    private final Parking parking;
    private final Random random;

    public Car(String name, Parking parking) {
        super(name);
        this.parking = parking;
        this.random = new Random();
    }

    @Override
    public void run() {
        int minTimeout = 2500;
        int maxTimeout = 7500;
        if (parking.park(this, random.nextInt((maxTimeout - minTimeout) + minTimeout))) {
            int parkingTime = random.nextInt((maxTimeout - minTimeout) + minTimeout);
            try {
                TimeUnit.MILLISECONDS.sleep(parkingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            parking.leave(this);
        } else {
            System.out.println(getName() + " didn't wait for a free parking space and drove away");
        }
    }
}
