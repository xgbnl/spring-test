package com.example.api.http.controllers;

import com.example.api.mapper.UserMapper;
import com.example.api.models.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("api/")
final public class Controller {

    private final UserMapper mapper;

    public Controller(UserMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("tests")
    public List<User> index()  {
        return this.mapper.getUsers();
    }
}
