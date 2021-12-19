package com.epam.training.student_maksim_mayorov.error_exceptions.main_task.exceptions;

public class LackAnySubjectException extends RuntimeException {

    public LackAnySubjectException() {

    }

    public LackAnySubjectException(String message) {
        super(message);
    }

    public LackAnySubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public LackAnySubjectException(Throwable cause) {
        super(cause);
    }
}
