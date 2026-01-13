package com.enzo.courseplatform.service;

import com.enzo.courseplatform.dto.request.LoginRequest;
import com.enzo.courseplatform.dto.response.LoginResponse;
import com.enzo.courseplatform.exception.ResourceNotFoundException;
import com.enzo.courseplatform.model.User;
import com.enzo.courseplatform.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login (LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.email()).orElseThrow(()-> new ResourceNotFoundException("Invalid credentials"));
        if(!passwordEncoder.matches(loginRequest.password(),user.getPassword())){
            throw new ResourceNotFoundException("Invalid credentials");
        }
        String token = jwtService.generateToken(user.getId(), user.getRole().name());
        return new LoginResponse(token);
    }



}
