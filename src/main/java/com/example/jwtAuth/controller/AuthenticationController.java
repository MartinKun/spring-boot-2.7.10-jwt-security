package com.example.jwtAuth.controller;

import com.example.jwtAuth.controller.request.AuthenticationRequest;
import com.example.jwtAuth.controller.request.RegisterRequest;
import com.example.jwtAuth.controller.response.AuthenticationResponse;
import com.example.jwtAuth.service.implementation.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(userServiceImpl.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        AuthenticationResponse response = userServiceImpl.authenticate(request);
        return ResponseEntity.ok(response);
    }
}
