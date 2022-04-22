package com.example.davinci.service.impl;

import com.example.davinci.service.UserService;
import com.example.davinci.entity.User;
import com.example.davinci.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> loadUserByEmail(String email){
        List<User> users =null;
        User user =userMapper.loadUserByEmail(email);
        users =userMapper.select(user);
        return users;
    }
    @Override
    public void addUser(User user){
        userMapper.insert(user);
    }
}
