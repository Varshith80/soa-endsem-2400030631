package com.klef.soa.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.exam.dto.UserResponse;
import com.klef.soa.exam.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    // GET user by username
    @GetMapping("/username")
    public ResponseEntity<UserResponse> getUserByUsername(
            @RequestParam String username) {

        UserResponse user =
                userService.getUserByUsername(username);

        return ResponseEntity.ok(user);
    }

    // GET user by ID
    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponse> getUserById(
            @PathVariable Long id) {

        UserResponse user = userService.getUserById(id);

        return ResponseEntity.ok(user);
    }
}