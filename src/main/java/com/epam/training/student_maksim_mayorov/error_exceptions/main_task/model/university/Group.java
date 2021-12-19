package com.epam.training.student_maksim_mayorov.error_exceptions.main_task.model.university;

import com.epam.training.student_maksim_mayorov.error_exceptions.main_task.exceptions.LackStudentsInGroupException;

import java.util.List;

public class Group {

    private final String name;
    private final List<Student> students;

    public Group(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public double averageGradeBySubject(String subjectName) {
        if (students.size() == 0) {
            throw new LackStudentsInGroupException("No students in the group");
        }
        double sum = 0;
        int countStudents = 0;
        for (Student student: students) {
            // If averageGrade is zero, then the student does not have this subject, so skip it
            double averageGrade = student.averageStudentGradeBySubject(subjectName);
            if (averageGrade != 0) {
                sum += averageGrade;
                countStudents++;
            }
        }
        return countStudents != 0 ? (sum / countStudents) : 0;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }
}
