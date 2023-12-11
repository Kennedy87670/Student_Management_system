package com.admin_student.spring_studentMs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDto {

    private  Long id;


    private String firstName;


    private String lastName;


    private String email;


    private String userName;
}
