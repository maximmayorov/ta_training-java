package com.epam.training.student_maksim_mayorov.collections.main_task;

import com.epam.training.student_maksim_mayorov.collections.main_task.model.NewYearGiftBox;
import com.epam.training.student_maksim_mayorov.collections.main_task.model.sweets.AbstractSweet;
import com.epam.training.student_maksim_mayorov.collections.main_task.model.sweets.Candy;
import com.epam.training.student_maksim_mayorov.collections.main_task.model.sweets.ChocolateBar;
import com.epam.training.student_maksim_mayorov.collections.main_task.model.sweets.Cookie;
import com.epam.training.student_maksim_mayorov.collections.main_task.model.types.CandyFilling;
import com.epam.training.student_maksim_mayorov.collections.main_task.model.types.ChocolateType;
import com.epam.training.student_maksim_mayorov.collections.main_task.model.types.CookieType;

import java.util.Arrays;
import java.util.List;

public class Runner {

    private static final List<AbstractSweet> sweets = Arrays.asList(
            new Candy("Candy 1", 14, 38, 27, 20, CandyFilling.NUT),
            new Candy("Candy 2", 25, 57, 43, 60, CandyFilling.SOUFFLE),
            new Candy("Candy 3", 17, 36, 29, 20, CandyFilling.NOUGAT),
            new Candy("Candy 4", 20, 54, 40, 60, CandyFilling.NUT),
            new Candy("Candy 5", 10, 36, 26, 20, CandyFilling.NUT),
            new ChocolateBar("Alpen Gold", 50, 120, 30, ChocolateType.BLACK, 70),
            new ChocolateBar("Milka", 60, 200, 100, ChocolateType.MILK, 80),
            new ChocolateBar("KitKat", 55, 135, 80, ChocolateType.WHITE, 75),
            new Cookie("Biscuit 1", 16, 45, 20, CookieType.OATMEAL_RAISIN),
            new Cookie("Biscuit 2", 15, 45, 15, CookieType.PEANUT_BUTTER)
    );

    public static void main(String[] args) {

//        Задание. Создать консольное приложение, удовлетворяющее следующим требованиям:
//        Каждый класс должен иметь отражающее смысл название и информативный состав.
//        Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
//        Наследование должно применяться только тогда, когда это имеет смысл.
//        При кодировании должны быть использованы соглашения об оформлении кода java code convention.
//        Классы должны быть грамотно разложены по пакетам
//        Консольное меню должно быть минимальным.
//        Для хранения параметров инициализации можно использовать файлы.

//        2. Новогодний подарок. Определить иерархию конфет и прочих сладостей. Создать несколько объектов-конфет.
//           Собрать детский подарок с определением его веса.
//           Провести сортировку конфет в подарке на основе одного из параметров. Найти конфету в подарке,
//           соответствующую заданному диапазону содержания сахара.

        NewYearGiftBox newYearGift = new NewYearGiftBox(sweets);
        System.out.println("A New Year's present is assembled.\nIt's weight: " + newYearGift.getGiftBoxWeight() + " grams");
        newYearGift.sortSweetsBySugarCount();
        System.out.println("Candies in the gift are sorted by sugar content");
        System.out.println("Candy in the gift, corresponding to a given range of sugar content:");
        System.out.println(newYearGift.getCandyWithSugarCountInRange(30, 100));
    }
}
