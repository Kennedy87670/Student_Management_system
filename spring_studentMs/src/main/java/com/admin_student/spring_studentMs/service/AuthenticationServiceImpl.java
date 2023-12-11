package com.admin_student.spring_studentMs.service;


import com.admin_student.spring_studentMs.auth.AuthenticationRequest;
import com.admin_student.spring_studentMs.auth.AuthenticationResponse;
import com.admin_student.spring_studentMs.auth.RegisterRequest;
import com.admin_student.spring_studentMs.entity.User;
import com.admin_student.spring_studentMs.errorAndException.UserEmailExistException;
import com.admin_student.spring_studentMs.errorAndException.UserNameExistException;
import com.admin_student.spring_studentMs.repository.StaffRepository;
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
    private final StaffRepository staffRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtServiceImpl jwtServiceImpl;
    private  final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) throws UserEmailExistException, UserNameExistException {
        if (emailExists(request.getEmail())) {
            throw new UserEmailExistException("User with email " + request.getEmail()  +  " already exists");
        }
        if (getUsername(request.getUserName())) {
            throw new UserNameExistException("Username "  + request.getUserName()  +   " already exists");
        }

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepository.save(user);
        var jwtToken = jwtServiceImpl.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    private boolean getUsername(String userName){
        return userRepository.findUserByUserName(userName).isPresent();
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
