package com.nielo.springsecuritybasicauth.springsecuritybasicauth.service;

import com.nielo.springsecuritybasicauth.springsecuritybasicauth.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserByUsername(String username);

    List<User> getAllUsers();

    User getUserById(String id);
}
