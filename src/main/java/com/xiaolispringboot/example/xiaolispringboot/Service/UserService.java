package com.xiaolispringboot.example.xiaolispringboot.Service;


import com.xiaolispringboot.example.xiaolispringboot.model.User;

public interface UserService {
    public void Insert(User user);
    public User Select(String Token);
}
