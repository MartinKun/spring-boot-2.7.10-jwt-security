package com.example.jwtAuth.service.implementation;

import com.example.jwtAuth.auth.JwtService;
import com.example.jwtAuth.controller.request.AuthenticationRequest;
import com.example.jwtAuth.controller.request.RegisterRequest;
import com.example.jwtAuth.controller.response.AuthenticationResponse;
import com.example.jwtAuth.model.entity.Role;
import com.example.jwtAuth.model.entity.User;
import com.example.jwtAuth.model.enums.RoleEnum;
import com.example.jwtAuth.repository.RoleRepository;
import com.example.jwtAuth.repository.UserRepository;
import com.example.jwtAuth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail()))
            throw new RuntimeException("email is already in use");

        String password = passwordEncoder.encode(request.getPassword());
        Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("role does not exist"));
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        User user = User.builder()
                .email(request.getEmail())
                .password(password)
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .roles(roles)
                .build();


        userRepository.save(user);

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );
        String token = jwtService.generateToken(authentication);

        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtService.generateToken(authentication);

        User user = (User) authentication.getPrincipal();

        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

}
