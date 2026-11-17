package com.klef.soa.exam.service;

import com.klef.soa.exam.dto.UserResponse;

public interface UserService {

    // Find user by username
    UserResponse getUserByUsername(String username);

    // Find user by ID
    UserResponse getUserById(Long id);

}