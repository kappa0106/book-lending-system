package com.example.springboot.service.impl;

import org.springframework.stereotype.Service;

import com.example.springboot.service.IAuthenticationService;

@Service
public class AuthenticationService implements IAuthenticationService {
    
    @Override
    public boolean isAuthenticated(String token) {

        return false;
    }

}
