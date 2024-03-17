package com.example.springboot.service;

import com.example.springboot.entity.User;

public interface IUserService {
    User registerUser(User user);
    User loginUser(User user);
}
