package com.example.springboot.mapper;

import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByPhoneNumber(String phoneNumber);
    User findByPhoneNumberAndPassword(String phoneNumber, String password);
    void save(User user);
}
