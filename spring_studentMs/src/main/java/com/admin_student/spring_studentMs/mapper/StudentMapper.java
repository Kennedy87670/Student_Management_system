package com.admin_student.spring_studentMs.mapper;

import com.admin_student.spring_studentMs.auth.RegisterRequest;
import com.admin_student.spring_studentMs.dto.StudentDto;
import com.admin_student.spring_studentMs.entity.Students;


public class StudentMapper {

    public static StudentDto maptToStudentDto(Students students){
        StudentDto studentDto = new StudentDto(
                students.getId(),
                students.getFirstName(),
                students.getLastName(),
                students.getUserName(),
                students.getEmail(),
                students.getGrade()
        );
        return studentDto;
    }
    public static Students mapToStudent(StudentDto studentDto){
        Students students = new Students(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getUserName(),
                studentDto.getEmail(),
                studentDto.getGrade()
        );
        return students;
    }


    public static Students mapToStudent(RegisterRequest request) {
        return Students.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .userName(request.getUserName())
                .build();
    }

}
