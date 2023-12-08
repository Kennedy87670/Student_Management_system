package com.admin_student.spring_studentMs.service;


import com.admin_student.spring_studentMs.auth.AuthenticationRequest;
import com.admin_student.spring_studentMs.auth.AuthenticationResponse;
import com.admin_student.spring_studentMs.auth.RegisterRequest;
import com.admin_student.spring_studentMs.entity.Role;
import com.admin_student.spring_studentMs.entity.User;
import com.admin_student.spring_studentMs.mapper.AdminMapper;
import com.admin_student.spring_studentMs.mapper.ParentMapper;
import com.admin_student.spring_studentMs.mapper.StudentMapper;
import com.admin_student.spring_studentMs.repository.AdminRepository;
import com.admin_student.spring_studentMs.repository.ParentRepository;
import com.admin_student.spring_studentMs.repository.StudentsRepository;
import com.admin_student.spring_studentMs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl {

    private final UserRepository userRepository;
    private final StudentsRepository studentsRepository;
    private final ParentRepository parentRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtServiceImpl jwtServiceImpl;
    private  final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        Role userRole = determineRole(request);
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .userName(request.getUserName())
                .userType(request.getUserType())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(userRole)
                .build();

        userRepository.save(user);
        var jwtToken = jwtServiceImpl.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private Role determineRole(RegisterRequest request) {
        String userType = request.getUserType();

        if (userType != null) {
            switch (userType.toUpperCase()) {
                case "STUDENTS":
                    studentsRepository.save(StudentMapper.mapToStudent(request));
                    return Role.STUDENTS;
                case "PARENTS":
                    parentRepository.save(ParentMapper.mapToParent(request));
                    return Role.PARENTS;
                case "STAFF":
                    adminRepository.save(AdminMapper.mapToAdmin(request));
                    return Role.STAFF;
                default:
                    throw new IllegalArgumentException("Invalid user type: " + userType);
            }
        } else {
            // Default role if user type is not provided
            return Role.STUDENTS;
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtServiceImpl.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
