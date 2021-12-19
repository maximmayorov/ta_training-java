package com.epam.training.student_maksim_mayorov.error_exceptions.main_task.model.university;

import com.epam.training.student_maksim_mayorov.error_exceptions.main_task.exceptions.LackGroupsInFacultyException;

import java.util.List;

public class Faculty {

    private final String name;
    private final List<Group> groups;

    public Faculty(String name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public double averageGradeInGroup(String groupName, String subjectName) {
        if (groups.size() == 0) {
            throw new LackGroupsInFacultyException("No groups in the faculty");
        }
        double grade = 0;
        for (Group group: groups) {
            if (group.getName().equals(groupName)) {
                grade = group.averageGradeBySubject(subjectName);
                break;
            }
        }
        return grade;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public String getName() {
        return name;
    }
}
