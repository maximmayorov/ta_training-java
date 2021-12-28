package com.epam.training.student_maksim_mayorov.threads.optional_task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Plane extends Thread {

    private final BlockingQueue<Runway> runways;

    public Plane(String name, BlockingQueue<Runway> runways) {
        super(name);
        this.runways = runways;
    }

    @Override
    public void run() {
        try {
            Runway runway = runways.take();
            runway.takePlane(this);
            System.out.println(this.getName() + " began to enter the " + runway.getName());
            TimeUnit.SECONDS.sleep(3);
            System.out.println(this.getName() + " took off from " + runway.getName());
            runway.release();
            runways.put(runway);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
