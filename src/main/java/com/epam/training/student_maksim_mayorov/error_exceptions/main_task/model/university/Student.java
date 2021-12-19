package com.epam.training.student_maksim_mayorov.error_exceptions.main_task.model.university;

import com.epam.training.student_maksim_mayorov.error_exceptions.main_task.exceptions.LackAnySubjectException;

import java.util.List;

public class Student {

    private final String name;
    private final List<Subject> subjects;

    public Student(List<Subject> subjects, String name) {
        this.subjects = subjects;
        this.name = name;
    }

    public double averageStudentGrade() {
        if (subjects.size() < 1) {
            throw new LackAnySubjectException("The student has no subjects");
        }
        double sum = 0;
        for (Subject subject: subjects) {
            sum += subject.averageGrade();
        }
        return sum / subjects.size();
    }

    public double averageStudentGradeBySubject(String subjectName) {
        if (subjects.size() < 1) {
            throw new LackAnySubjectException("The student has no subjects");
        }
        double grade = 0;
        for (Subject subject: subjects) {
            if (subject.getName().equals(subjectName)) {
                grade = subject.averageGrade();
                break;
            }
        }
        return grade;
    }

    public String getName() {
        return name;
    }
}
