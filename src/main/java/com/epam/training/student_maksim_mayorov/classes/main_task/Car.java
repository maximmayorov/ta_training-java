package com.epam.training.student_maksim_mayorov.classes.main_task;

public class Car {

    private int id;
    private String brand;
    private String model;
    private int year;
    private Colors color;
    private int price;
    private String registrationNumber;

    public Car() {

    }

    public Car(int id, String brand, String model, int year, Colors color, int price, String registrationNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearOfManufacture(int year) {
        this.year = year;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public Colors getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", Brand='" + brand + '\'' +
                ", Model='" + model + '\'' +
                ", yearOfManufacture=" + year +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", registrationNumber=" + registrationNumber +
                '}';
    }

}