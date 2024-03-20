package com.example.demo.controller;

import com.example.demo.module.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController()
public class UserController {
    @Autowired
    private UserService userService;
    UserController(UserService userService)
    {
        this.userService= userService;
    }
    @GetMapping()
    public List<User> getAllUsers()
    {
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id)
    {
        return userService.findById(id);
    }
    @PostMapping("/AddUser")
    public User AddUser(@RequestBody User user)
    {
        return  userService.AddUser(user);
    }
    @PutMapping("/{id}")
    public User UpdateById(@PathVariable long id , @RequestBody User user)
    {
        return userService.ModifyUser(user,id);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id)
    {
        userService.deleteById(id);
    }
}
