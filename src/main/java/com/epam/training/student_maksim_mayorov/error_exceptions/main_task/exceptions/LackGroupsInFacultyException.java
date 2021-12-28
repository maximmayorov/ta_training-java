package com.epam.training.student_maksim_mayorov.error_exceptions.main_task.exceptions;

public class LackGroupsInFacultyException extends RuntimeException {

    public LackGroupsInFacultyException() {

    }

    public LackGroupsInFacultyException(String message) {
        super(message);
    }

    public LackGroupsInFacultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public LackGroupsInFacultyException(Throwable cause) {
        super(cause);
    }
}
