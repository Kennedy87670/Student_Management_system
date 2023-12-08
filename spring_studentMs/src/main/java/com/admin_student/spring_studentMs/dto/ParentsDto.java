package com.admin_student.spring_studentMs.dto;

import com.admin_student.spring_studentMs.entity.Students;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ParentsDto {
    private  Long id;


    private String firstName;


    private String lastName;


    private String email;


    private String userName;


}
