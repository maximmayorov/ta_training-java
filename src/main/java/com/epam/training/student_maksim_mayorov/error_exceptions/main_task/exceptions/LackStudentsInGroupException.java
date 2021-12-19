package com.epam.training.student_maksim_mayorov.error_exceptions.main_task.exceptions;

public class LackStudentsInGroupException extends RuntimeException {

    public LackStudentsInGroupException() {

    }

    public LackStudentsInGroupException(String message) {
        super(message);
    }

    public LackStudentsInGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public LackStudentsInGroupException(Throwable cause) {
        super(cause);
    }
}
