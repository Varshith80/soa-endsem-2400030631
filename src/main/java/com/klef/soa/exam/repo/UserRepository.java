package com.klef.soa.exam.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.exam.entity.User;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    // Find user by username
    Optional<User> findByUsername(String username);

}