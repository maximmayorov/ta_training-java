package com.epam.training.student_maksim_mayorov.error_exceptions.main_task.model.university;

import com.epam.training.student_maksim_mayorov.error_exceptions.main_task.exceptions.LackFacultiesInUniversityException;
import com.epam.training.student_maksim_mayorov.error_exceptions.main_task.exceptions.LackGroupsInFacultyException;
import com.epam.training.student_maksim_mayorov.error_exceptions.main_task.exceptions.LackStudentsInGroupException;

import java.util.List;

public class University {

    private final List<Faculty> faculties;

    public University(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void printAverageGradeInGroup(String facultyName, String groupName, String subjectName) {
        if (faculties.size() == 0) {
            throw new LackFacultiesInUniversityException("There are no faculties at the university");
        }
        if (faculties.stream().noneMatch(faculty -> faculty.getName().equals(facultyName))) {
            System.out.println(facultyName + " faculty does not exist");
            return;
        }
        double grade = 0;
        for (Faculty faculty: faculties) {
            if (faculty.getName().equals(facultyName)) {
                grade = faculty.averageGradeInGroup(groupName, subjectName);
                if (grade == 0) {
                    System.out.println(groupName + " group does not exist");
                    return;
                }
                break;
            }
        }
        System.out.println("Subject: " + subjectName + ", faculty: " + facultyName + ", group: " + groupName +  ", average grade: " + grade);
    }

    public void printAverageGradeBySubject(String subjectName) {
        if (faculties.size() == 0) {
            throw new LackFacultiesInUniversityException("There are no faculties at the university");
        }
        double sum = 0;
        int studentsCount = 0;
        for (Faculty faculty: faculties) {
            if (faculty.getGroups().size() == 0) {
                throw new LackGroupsInFacultyException("No groups in the faculty");
            }
            for (Group group: faculty.getGroups()) {
                if (group.getStudents().size() == 0) {
                    throw new LackStudentsInGroupException("No students in the group");
                }
                for (Student student: group.getStudents()) {
                    sum += student.averageStudentGradeBySubject(subjectName);
                }
                studentsCount += group.getStudents().size();
            }
        }
        if (sum == 0 || studentsCount == 0) {
            System.out.println(subjectName + "does not exist or students don't have it");
        } else {
            System.out.println("Subject: " + subjectName + ", average university-wide grade: " + sum / studentsCount);
        }
    }
}
