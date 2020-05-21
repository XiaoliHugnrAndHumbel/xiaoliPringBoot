package com.xiaolispringboot.example.xiaolispringboot.Service.impl;

import com.xiaolispringboot.example.xiaolispringboot.Service.UserService;
import com.xiaolispringboot.example.xiaolispringboot.mapper.UserMapper;
import com.xiaolispringboot.example.xiaolispringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    public UserMapper userMapper;
    @Override
    public void Insert(User user){
        userMapper.Insert(user);
    }
    @Override
    public User Select(String token){
       User user= userMapper.Select(token);
        return user;
    }
}
