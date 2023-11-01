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
    public void index() throws IOException {

//        String resource = "mybatis/mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        try(SqlSession session = sqlSessionFactory.openSession()){
//          UserMapper userMapper =  session.getMapper(UserMapper.class);
//
//            List<User> users = userMapper.getUsers();
//
//            System.out.println(users);
//        }

        System.out.println(this.mapper.getUsers());

    }
}
