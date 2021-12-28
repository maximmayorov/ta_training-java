package com.epam.training.student_maksim_mayorov.error_exceptions.main_task.exceptions;

public class GradeOutOfRangeException extends RuntimeException {

    public GradeOutOfRangeException() {

    }

    public GradeOutOfRangeException(String message) {
        super(message);
    }

    public GradeOutOfRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public GradeOutOfRangeException(Throwable cause) {
        super(cause);
    }
}
