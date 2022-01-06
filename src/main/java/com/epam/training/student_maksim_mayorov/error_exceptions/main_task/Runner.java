package com.epam.training.student_maksim_mayorov.error_exceptions.main_task;

import com.epam.training.student_maksim_mayorov.error_exceptions.main_task.model.university.Faculty;
import com.epam.training.student_maksim_mayorov.error_exceptions.main_task.model.university.Group;
import com.epam.training.student_maksim_mayorov.error_exceptions.main_task.model.university.Student;
import com.epam.training.student_maksim_mayorov.error_exceptions.main_task.model.university.Subject;
import com.epam.training.student_maksim_mayorov.error_exceptions.main_task.model.university.University;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

//        В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы.
//        У каждого студента есть несколько учебных предметов по которым он получает оценки.
//        Необходимо реализовать иерархию студентов, групп и факультетов.
//
//        Посчитать средний балл по всем предметам студента
//        Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
//        Посчитать средний балл по предмету для всего университета
//        Релизовать следующие исключения:
//
//        Оценка ниже 0 или выше 10
//        Отсутсвие предметов у студента (должен быть хотя бы один)
//        Отсутствие студентов в группе
//        Отсутствие групп на факультете
//        Отсутствие факультетов в университете

        List<Student> students = createStudents();
        Faculty faculty = new Faculty("Faculty1", Collections.singletonList(new Group("Group1", students)));
        University university = new University(Collections.singletonList(faculty));
        System.out.println("Student: " + students.get(0).getName() + ", average grade in all subjects of the student: " + students.get(0).averageStudentGrade());
        university.printAverageGradeInGroup("Faculty1", "Group1", "Algebra");
        university.printAverageGradeBySubject("Algebra");
    }

    private static List<Student> createStudents() {
        Student student1 = new Student(Arrays.asList(
                new Subject("Algebra", new int[] {3, 2, 4, 5, 5,5, 5, 4}),
                new Subject("Physics", new int[] {3, 2, 4, 2,5 ,5, 3, 4}),
                new Subject("History", new int[] {5, 2, 4, 5, 5,4, 5, 4})), "Student1");

        Student student2 = new Student(Arrays.asList(
                new Subject("Algebra", new int[] {3, 2, 3, 2, 5,4, 3, 5}),
                new Subject("Physics", new int[] {3, 2, 3, 5,5 ,5, 3, 5}),
                new Subject("History", new int[] {5, 2, 3, 4, 5,4, 5, 5})), "Student2");

        Student student3 = new Student(Arrays.asList(
                new Subject("Algebra", new int[] {3, 4, 4, 4, 5,4, 3, 5}),
                new Subject("Physics", new int[] {4, 4, 3, 5,5 ,4, 3, 2}),
                new Subject("History", new int[] {4, 2, 3, 3, 2,5, 5, 5})), "Student3");
        return Arrays.asList(student1, student2, student3);
    }
}
