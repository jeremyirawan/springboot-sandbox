package com.example.sandbox.sandbox.service;

import com.example.sandbox.sandbox.dto.UserDto;
import com.example.sandbox.sandbox.model.User;
import com.example.sandbox.sandbox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        // Implement logic to return a maximum of 10 users
    }

    public User saveUser(UserDto userDto) {
        // Implement logic to save user to the database
    }

    public User getUserById(UUID userId) {
        // Implement logic to retrieve a user by ID

        return User;
    }
}