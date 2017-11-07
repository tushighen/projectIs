package com.example.repository;

import com.example.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

//@Configuration
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByUserName(String userName);
}
