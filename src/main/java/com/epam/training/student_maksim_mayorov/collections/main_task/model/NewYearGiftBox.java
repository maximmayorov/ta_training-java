package com.epam.training.student_maksim_mayorov.collections.main_task.model;

import com.epam.training.student_maksim_mayorov.collections.main_task.model.sweets.AbstractSweet;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class NewYearGiftBox {
    private final List<AbstractSweet> sweets;

    public NewYearGiftBox(List<AbstractSweet> sweets) {
        this.sweets = sweets;
    }

    public List<AbstractSweet> getSweets() {
        return sweets;
    }

    public int getGiftBoxWeight() {
        int giftBoxWeight = 0;
        for (AbstractSweet sweet : sweets) {
            giftBoxWeight += sweet.getWeight();
        }
        return giftBoxWeight;
    }

    public void sortSweetsByWeight() {
        sweets.sort(Comparator.comparingInt(AbstractSweet::getWeight));
    }

    public void sortSweetsBySugarCount() {
        sweets.sort(Comparator.comparingInt(AbstractSweet::getSugarCount));
    }

    public void sortSweetsByPrice() {
        sweets.sort(Comparator.comparingInt(AbstractSweet::getPrice));
    }

    public void sortSweetsByName() {
        sweets.sort(Comparator.comparing(AbstractSweet::getName));
    }

    public AbstractSweet getCandyWithSugarCountInRange(int from, int to) {
        AbstractSweet sweetWithSugarInRange  = null;
        for (AbstractSweet sweet : sweets) {
            if (sweet.getSugarCount() >= from && sweet.getSugarCount() <= to) {
                sweetWithSugarInRange = sweet;
                break;
            }
        }
        return sweetWithSugarInRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewYearGiftBox newYearGiftBox = (NewYearGiftBox) o;
        return Objects.equals(sweets, newYearGiftBox.sweets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sweets);
    }

    @Override
    public String toString() {
        return "GiftBox{" +
                "sweets=" + sweets +
                '}';
    }
}
