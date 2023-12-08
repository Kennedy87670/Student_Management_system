package com.admin_student.spring_studentMs.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class GradesDto {

    private Long id;

    private String subject;


//    @Score
    private String score;
}
