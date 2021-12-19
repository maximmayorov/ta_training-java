package com.epam.training.student_maksim_mayorov.collections.main_task.model.sweets;

import java.util.Objects;

public abstract class AbstractSweet {

    private String name;
    private int price;
    private int weight;
    private int sugarCount;

    public AbstractSweet(String name, int price, int weight, int sugarCount) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.sugarCount = sugarCount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public int getSugarCount() {
        return sugarCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void setWeight(int weight) {
        if (weight >= 0) {
            this.weight = weight;
        }
    }

    public void setSugarCount(int sugarCount) {
        if (sugarCount >= 0) {
            this.sugarCount = sugarCount;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractSweet abstractSweet = (AbstractSweet) o;
        return abstractSweet.weight == weight &&
                abstractSweet.sugarCount == sugarCount &&
                Objects.equals(name, abstractSweet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, sugarCount);
    }

    @Override
    public String toString() {
        return "Sweet{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", sugarCount=" + sugarCount +
                '}';
    }
}
