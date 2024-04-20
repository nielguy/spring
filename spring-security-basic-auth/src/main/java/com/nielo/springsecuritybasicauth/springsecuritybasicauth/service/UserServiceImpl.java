package com.nielo.springsecuritybasicauth.springsecuritybasicauth.service;

import com.nielo.springsecuritybasicauth.springsecuritybasicauth.exception.ResourceNotFoundException;
import com.nielo.springsecuritybasicauth.springsecuritybasicauth.model.User;
import com.nielo.springsecuritybasicauth.springsecuritybasicauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }


    @Override
    public User createUser(User user) {
        User userToBeCreated = new User();
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        userToBeCreated.setName(user.getName());
        userToBeCreated.setUsername(user.getUsername());
        userToBeCreated.setPassword(encodedPassword);
        return userRepository.save(userToBeCreated);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for the id: "+id));
    }

}
