package com.epam.training.student_maksim_mayorov.classes.main_task;

import java.util.Calendar;

public class CarShowroom {

    Car[] cars;

    public CarShowroom(Car[] cars) {
        this.cars = cars;
    }

    public void carsOfBrand(Car[] cars, String brand) {
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(car);
            }
        }
    }

    public void carsOfModelOperatedMoreThanYears (Car[] cars, String model, int nYears) {
        for (Car car : cars) {
            if ((Calendar.getInstance().get(Calendar.YEAR) - car.getYear()) > nYears
                    && car.getModel().equals(model)) {
                System.out.println(car);
            }
        }
    }

    public void carsOfYearAndPrice(Car[] cars, int year, int price) {
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() > price) {
                System.out.println(car);
            }
        }
    }
}
