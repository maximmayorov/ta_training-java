package com.epam.training.student_maksim_mayorov.collections.optional_task;

import java.util.*;
import java.util.stream.Collectors;

public class Task5 {

    public static void main(String[] args) {

        // 5. Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец, а положительные — в начало списка.

        List<Integer> numbers;
        Random random = new Random();
        numbers = random.ints(10, -1000, 1000).boxed().collect(Collectors.toList());
        System.out.println(numbers);
        numbers.sort((o1, o2) -> o2 - o1);
        System.out.println(numbers);
    }
}
