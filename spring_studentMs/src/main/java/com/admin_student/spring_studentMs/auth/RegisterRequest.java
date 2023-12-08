package com.admin_student.spring_studentMs.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private  String firstname;

    private String lastname;

    private String userName;

    private String email;

    private String password;

    private String userType;

}
