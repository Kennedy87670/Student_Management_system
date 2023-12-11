package com.admin_student.spring_studentMs.errorAndException;

public class UserEmailExistException extends Exception{
    public UserEmailExistException() {
        super();
    }

    public UserEmailExistException(String message) {
        super(message);
    }

    public UserEmailExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserEmailExistException(Throwable cause) {
        super(cause);
    }

    protected UserEmailExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
