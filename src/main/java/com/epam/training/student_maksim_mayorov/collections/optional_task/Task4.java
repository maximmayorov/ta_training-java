package com.epam.training.student_maksim_mayorov.collections.optional_task;

import java.util.*;

public class Task4 {

    private static final List<String> poem = Arrays.asList(
            "Two roads diverged in a yellow wood,",
            "And sorry I could not travel both",
            "And be one traveler, long I stood",
            "And looked down one as far as I could",
            "To where it bent in the undergrowth.",

            "Then took the other, as just as fair",
            "And having perhaps the better claim",
            "Because it was grassy and wanted wear;",
            "Though as for that the passing there",
            "Had worn them really about the same.",

            "And both that morning equally lay",
            "In leaves no step had trodden black.",
            "Oh, I kept the first for another day!",
            "Yet knowing how way leads on to way,",
            "I doubted if I should ever come back.",

            "I shall be telling this with a sigh",
            "Somewhere ages and ages hence:",
            "Two roads diverged in a wood, and I—",
            "I took the one less traveled by,",
            "And that has made all the difference."
    );

    public static void main(String[] args) {

        // 4. Занести стихотворение в список. Провести сортировку по возрастанию длин строк.

        poem.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        poem.forEach(System.out::println);
    }
}
