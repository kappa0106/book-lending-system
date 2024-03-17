package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class PasswordRequest {
    private String id;
    private String password;
    private String newPassword;
}
