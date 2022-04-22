package com.example.davinci.service;
import com.example.davinci.entity.User;

import java.util.List;

public interface UserService {
    List<User> loadUserByEmail(String email);
    void addUser(User user);
}
