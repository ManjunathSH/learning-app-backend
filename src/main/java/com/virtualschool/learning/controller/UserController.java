package com.virtualschool.learning.controller;

import com.virtualschool.learning.entity.User;
import com.virtualschool.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path="/api/user/save")
    public User save(@RequestBody User user){

        return userService.saveUser(user);
    }

    @GetMapping(path = "/api/user/{userId}")
    public Optional<User> getUserById(@PathVariable(name="userId")String userId){
        return userService.getUserById(userId);
    }

    @GetMapping(path = "/api/user/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
