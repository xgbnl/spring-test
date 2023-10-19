package com.example.api.controllers;

import com.example.api.mapper.UserMapper;
import com.example.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
@GetMapping("/users")
    public List<User> index() {

        return userMapper.users();
    }
}
