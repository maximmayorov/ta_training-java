package com.epam.training.student_maksim_mayorov.error_exceptions.main_task.model.university;

import com.epam.training.student_maksim_mayorov.error_exceptions.main_task.exceptions.GradeOutOfRangeException;

public class Subject {

    private final String name;
    private final int[] grades;

    public Subject(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }

    public double averageGrade() {
        int sum = 0;
        for (int grade: grades) {
            if (grade < 0 || grade > 10) {
                throw new GradeOutOfRangeException("The grade must be between 0 and 10");
            }
            sum += grade;
        }
        return sum / (double) grades.length;
    }

    public String getName() {
        return name;
    }

}
