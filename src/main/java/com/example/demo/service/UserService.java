package com.example.demo.service;

import com.example.demo.module.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User findById(long id);
    List<User> findAll();
    User AddUser(User user);
    User ModifyUser(User user,long id);
    void deleteById(long id);

}
