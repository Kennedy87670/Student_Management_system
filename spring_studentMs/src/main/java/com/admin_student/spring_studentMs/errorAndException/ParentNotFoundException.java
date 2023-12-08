package com.admin_student.spring_studentMs.errorAndException;

public class ParentNotFoundException extends Exception{
    public ParentNotFoundException() {
        super();
    }

    public ParentNotFoundException(String message) {
        super(message);
    }

    public ParentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParentNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ParentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
