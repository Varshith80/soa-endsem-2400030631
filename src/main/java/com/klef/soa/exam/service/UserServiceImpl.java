package com.klef.soa.exam.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.exam.dto.UserResponse;
import com.klef.soa.exam.entity.User;
import com.klef.soa.exam.repo.UserRepository;
import com.klef.soa.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Find user by username
    @Override
    public UserResponse getUserByUsername(String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                    new RuntimeException("User not found with username: " + username)
                );

        return convertToDTO(user);
    }

    // Find user by ID
    @Override
    public UserResponse getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("User not found with ID: " + id)
                );

        return convertToDTO(user);
    }

    // Convert Entity into DTO
    private UserResponse convertToDTO(User user) {

        return new UserResponse(
            user.getId(),
            user.getUsername(),
            user.getFullName(),
            user.getEmail(),
            user.getPhone(),
            user.getAddress()
        );
    }
}