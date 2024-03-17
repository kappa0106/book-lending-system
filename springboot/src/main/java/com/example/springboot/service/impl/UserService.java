package com.example.springboot.service.impl;

import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User registerUser(User user) {
        userMapper.save(user);
        return user;
    }

    @Override
    public User loginUser(User user) {
        return userMapper.findByPhoneNumberAndPassword(user.getPhoneNumber(), user.getPassword());
    }
}
