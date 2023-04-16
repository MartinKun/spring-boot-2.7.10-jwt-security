package com.example.jwtAuth.controller.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
