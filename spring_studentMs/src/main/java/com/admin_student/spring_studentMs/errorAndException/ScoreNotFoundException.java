package com.admin_student.spring_studentMs.errorAndException;

public class ScoreNotFoundException extends Exception{
    public ScoreNotFoundException() {
        super();
    }

    public ScoreNotFoundException(String message) {
        super(message);
    }

    public ScoreNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScoreNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ScoreNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
