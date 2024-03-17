package com.example.springboot.service;

public interface IAuthenticationService {
    boolean isAuthenticated(String token);
    // 其他可能的身份验证方法
}
