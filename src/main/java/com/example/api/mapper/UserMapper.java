package com.example.api.mapper;

import com.example.api.models.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getUsers();

}
