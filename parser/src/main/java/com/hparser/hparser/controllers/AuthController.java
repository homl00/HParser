package com.hparser.hparser.controllers;

import com.hparser.hparser.DTOs.JwtRequestDto;
import com.hparser.hparser.DTOs.RegistrationUserDto;
import com.hparser.hparser.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequestDto loginRequest) {
        return authService.createAuthToken(loginRequest);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registerDTO) {
        return authService.createNewUser(registerDTO);
    }
}
