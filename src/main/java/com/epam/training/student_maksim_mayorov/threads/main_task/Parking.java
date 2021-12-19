package com.epam.training.student_maksim_mayorov.threads.main_task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Parking {
    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();
    private final List<Car> cars = new ArrayList<>();
    private final int maxFreePlaces;

    public Parking(int maxFreePlaces) {
        this.maxFreePlaces = maxFreePlaces;
    }

    public boolean park(Car car, int waitingTimeMillis) {
        long nanos = TimeUnit.MILLISECONDS.toNanos(waitingTimeMillis);
        lock.lock();
        try {
            System.out.println(car.getName() + " drove up to the parking lot");
            while (cars.size() >= maxFreePlaces) {
                if (nanos <= 0L) {
                    return false;
                }
                System.out.println(car.getName() + " waiting for a free parking space");
                nanos = condition.awaitNanos(nanos);
            }
            cars.add(car);
            System.out.println(car.getName() + " is parked");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return true;
    }

    public void leave(Car car) {
        lock.lock();
        try {
            cars.remove(car);
            System.out.println(car.getName() + " leave from parking lot");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

}
