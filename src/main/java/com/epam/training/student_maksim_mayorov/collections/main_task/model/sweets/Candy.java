package com.epam.training.student_maksim_mayorov.collections.main_task.model.sweets;

import com.epam.training.student_maksim_mayorov.collections.main_task.model.types.CandyFilling;

import java.util.Objects;

public class Candy extends AbstractSweet {

    private int cocoaAmount;
    private CandyFilling candyFilling;

    public Candy(String name, int price, int weight, int sugarCount, int cocoaAmount, CandyFilling candyFilling) {
        super(name, price, weight, sugarCount);
        this.cocoaAmount = cocoaAmount;
        this.candyFilling = candyFilling;
    }

    public int getCocoaAmount() {
        return cocoaAmount;
    }

    public CandyFilling getCandyFilling() {
        return candyFilling;
    }

    public void setCocoaAmount(int cocoaAmount) {
        this.cocoaAmount = cocoaAmount;
    }

    public void setCandyFilling(CandyFilling candyFilling) {
        this.candyFilling = candyFilling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candy candy = (Candy) o;
        return cocoaAmount == candy.cocoaAmount &&
                candyFilling == candy.candyFilling;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cocoaAmount, candyFilling);
    }

    @Override
    public String toString() {
        return "Candy{" +
                "cocoaAmount=" + cocoaAmount +
                ", candyFilling=" + candyFilling +
                "} " + super.toString();
    }
}
