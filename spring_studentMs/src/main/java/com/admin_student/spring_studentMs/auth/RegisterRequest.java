package com.admin_student.spring_studentMs.auth;

import com.admin_student.spring_studentMs.entity.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    private Role role;

}
