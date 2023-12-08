package com.admin_student.spring_studentMs.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDto {
    private Long id;


    private String subject;


    private String code;

    private String description;
}
