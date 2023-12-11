package com.admin_student.spring_studentMs.controller;

import com.admin_student.spring_studentMs.auth.AuthenticationRequest;
import com.admin_student.spring_studentMs.auth.AuthenticationResponse;
import com.admin_student.spring_studentMs.auth.RegisterRequest;
import com.admin_student.spring_studentMs.errorAndException.UserEmailExistException;
import com.admin_student.spring_studentMs.errorAndException.UserNameExistException;
import com.admin_student.spring_studentMs.service.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationServiceImpl service;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) throws UserEmailExistException, UserNameExistException {
        return ResponseEntity.ok(service.register(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
