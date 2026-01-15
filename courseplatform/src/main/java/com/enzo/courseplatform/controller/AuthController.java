package com.enzo.courseplatform.controller;

import com.enzo.courseplatform.dto.request.CreateUserRequest;
import com.enzo.courseplatform.dto.request.LoginRequest;
import com.enzo.courseplatform.dto.response.LoginResponse;
import com.enzo.courseplatform.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid CreateUserRequest request) {
        authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest){
        return authService.login(loginRequest);
    }


}
