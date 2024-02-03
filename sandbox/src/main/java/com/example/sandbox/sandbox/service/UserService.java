package com.example.sandbox.sandbox.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.sandbox.sandbox.dto.UserDto;
import com.example.sandbox.sandbox.model.User;
import com.example.sandbox.sandbox.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        // Implement logic to return a maximum of 10 users
        Pageable limit = PageRequest.of(0, 10); // Page number is 0 (first page), limit is 10
        return userRepository.findAll(limit).getContent();
    }

    public User saveUser(UserDto userDto) {
        // Use the User.Builder to create a new User instance
        User user = new User.Builder()
            .withFullname(userDto.getFullname())
            .withDateOfBirth(userDto.getDateOfBirth())
            .withGender(userDto.getGender())
            // ... set other properties from userDto using the builder methods ...
            .build();

        // Save the User entity to the database
        User savedUser = userRepository.save(user);

        // Return the saved User entity
        return savedUser;
    }

    public User getUserById(UUID userId) {
        Optional<User> user = userRepository.findById(userId);

        // Return the user if found, or handle the case where the user is not found
        return user.orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));
    }
}