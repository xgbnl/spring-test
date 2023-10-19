package com.example.api.mapper;

import com.example.api.models.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT id,phone FROM users")
    List<User> users();
}
