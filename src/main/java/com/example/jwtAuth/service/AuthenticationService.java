package com.example.jwtAuth.service;

import com.example.jwtAuth.controller.request.AuthenticationRequest;
import com.example.jwtAuth.controller.request.RegisterRequest;
import com.example.jwtAuth.controller.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
