package com.example.davinci.mapper;

import com.example.davinci.entity.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    User loadUserByEmail(String email);
    void addUser(User user);
}
