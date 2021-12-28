package com.epam.training.student_maksim_mayorov.error_exceptions.main_task.model.university;

import com.epam.training.student_maksim_mayorov.error_exceptions.main_task.exceptions.GradeOutOfRangeException;

import java.util.List;

public class Subject {

    private final String name;
    private final List<Integer> grades;

    public Subject(String name, List<Integer> grades) {
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
        return sum / (double) grades.size();
    }

    public String getName() {
        return name;
    }

}
