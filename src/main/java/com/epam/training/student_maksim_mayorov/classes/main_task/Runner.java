package com.epam.training.student_maksim_mayorov.classes.main_task;

public class Runner {

    public static void main(String[] args) {

//        Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
//        Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.
//        В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

//        8. Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.
//           Создать массив объектов. Вывести:
//        a) список автомобилей заданной марки;
//        b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
//        c) список автомобилей заданного года выпуска, цена которых больше указанной.

        Car[] cars = {
                new Car(1, "Skoda", "Octavia", 2007, Colors.GRAY, 5_500, "AB123CD"),
                new Car(2, "BMW", "M5", 2018, Colors.BLACK, 68_750, "EF456GH"),
                new Car(3, "Mercedes-Benz", "W124", 1992, Colors.BLACK, 2_748, "ML125RD"),
                new Car(4, "Toyota", "XV30", 2003, Colors.WHITE, 6_000, "AA777BB"),
                new Car(5, "BMW", "X5", 2008, Colors.GRAY, 17_862, "CD459WW"),
                new Car(6, "Toyota", "Mark 2", 2003, Colors.WHITE, 7_725, "AB129XZ"),
                new Car(7, "BMW", "E39", 2003, Colors.BLUE, 6_100, "DD412GH"),
                new Car(8, "Mercedes-Benz AMG", "GT 43", 2019, Colors.YELLOW, 115_189, "MB521RF"),
                new Car(9, "Volkswagen", "Passat B6 ", 2009, Colors.GREEN, 5_692, "EE788DR"),
                new Car(10, "BMW", "E39", 2001, Colors.RED, 4_608, "TR479LL"),
        };

        CarShowroom carShowroom = new CarShowroom(cars);
        System.out.println("BMW cars:");
        carShowroom.carsOfBrand(cars, "BMW");
        System.out.println("\nBMW E39 model cars that have been in use for more than 7 years:");
        carShowroom.carsOfModelOperatedMoreThanYears(cars, "E39", 18);
        System.out.println("\nCars of 2003 year of manufacture costing more than $6000:");
        carShowroom.carsOfYearAndPrice(cars, 2003, 6000);
    }
}
