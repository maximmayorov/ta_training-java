package com.epam.training.student_maksim_mayorov.collections.main_task.model.sweets;

import com.epam.training.student_maksim_mayorov.collections.main_task.model.types.ChocolateType;

import java.util.Objects;

public class ChocolateBar extends AbstractSweet {

    private ChocolateType chocolateType;
    private int cocoaAmount;

    public ChocolateBar(String name, int price, int weight, int sugarCount, ChocolateType chocolateType, int cocoaAmount) {
        super(name, price, weight, sugarCount);
        this.chocolateType = chocolateType;
        this.cocoaAmount = cocoaAmount;
    }

    public ChocolateType getChocolateType() {
        return chocolateType;
    }

    public int getCocoaAmount() {
        return cocoaAmount;
    }

    public void setChocolateType(ChocolateType chocolateType) {
        this.chocolateType = chocolateType;
    }

    public void setCocoaAmount(int cocoaAmount) {
        this.cocoaAmount = cocoaAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChocolateBar that = (ChocolateBar) o;
        return cocoaAmount == that.cocoaAmount &&
                chocolateType == that.chocolateType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), chocolateType, cocoaAmount);
    }

    @Override
    public String toString() {
        return "ChocolateBar{" +
                "chocolateType=" + chocolateType +
                ", cocoaAmount=" + cocoaAmount +
                "} " + super.toString();
    }
}
