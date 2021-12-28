package com.epam.training.student_maksim_mayorov.error_exceptions.main_task.exceptions;

public class LackFacultiesInUniversityException extends RuntimeException {

    public LackFacultiesInUniversityException() {

    }

    public LackFacultiesInUniversityException(String message) {
        super(message);
    }

    public LackFacultiesInUniversityException(String message, Throwable cause) {
        super(message, cause);
    }

    public LackFacultiesInUniversityException(Throwable cause) {
        super(cause);
    }
}
