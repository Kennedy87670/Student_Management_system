package com.admin_student.spring_studentMs.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {

    private  Long id;

    private String firstName;


    private String lastName;


    private String userName;

    private String email;


    private  String Grade;

}
