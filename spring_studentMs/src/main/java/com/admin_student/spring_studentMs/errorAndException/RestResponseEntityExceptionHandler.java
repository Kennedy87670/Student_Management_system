package com.admin_student.spring_studentMs.errorAndException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collections;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CourseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> HandleCourseNotFoundException(CourseNotFoundException exception, WebRequest request){

        LocalDateTime timestamp = LocalDateTime.now();
        ErrorResponse message = new ErrorResponse(timestamp, HttpStatus.NOT_FOUND, Collections.singletonList(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }

    @ExceptionHandler(GradeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> HandleGradeNotFoundException(GradeNotFoundException exception, WebRequest request){
        LocalDateTime timestamp = LocalDateTime.now();
        ErrorResponse message = new ErrorResponse(timestamp, HttpStatus.NOT_FOUND, Collections.singletonList(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);

    }

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> HandleStudentNotFoundException(StudentNotFoundException exception, WebRequest request){
        LocalDateTime timestamp = LocalDateTime.now();
        ErrorResponse message = new ErrorResponse(timestamp, HttpStatus.NOT_FOUND, Collections.singletonList(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);

    }

    @ExceptionHandler(ParentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> HandleParentNotFoundException(ParentNotFoundException exception, WebRequest request){
        LocalDateTime timestamp = LocalDateTime.now();
        ErrorResponse message = new ErrorResponse(timestamp, HttpStatus.NOT_FOUND, Collections.singletonList(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }

    @ExceptionHandler(AdminNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleAdminNotFoundException(AdminNotFoundException exception, WebRequest request) {
        LocalDateTime timestamp = LocalDateTime.now();
        ErrorResponse message = new ErrorResponse(timestamp, HttpStatus.NOT_FOUND, Collections.singletonList(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }


}
