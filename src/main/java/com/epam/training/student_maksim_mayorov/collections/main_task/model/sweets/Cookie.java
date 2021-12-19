package com.epam.training.student_maksim_mayorov.collections.main_task.model.sweets;

import com.epam.training.student_maksim_mayorov.collections.main_task.model.types.CookieType;

import java.util.Objects;

public class Cookie extends AbstractSweet {

    private CookieType cookieType;

    public Cookie(String name, int price, int weight, int sugarCount, CookieType cookieType) {
        super(name, price, weight, sugarCount);
        this.cookieType = cookieType;
    }

    public CookieType getCookieType() {
        return cookieType;
    }

    public void setCookieType(CookieType cookieType) {
        this.cookieType = cookieType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cookie cookie = (Cookie) o;
        return cookieType == cookie.cookieType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cookieType);
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "cookieType=" + cookieType +
                "} " + super.toString();
    }
}
