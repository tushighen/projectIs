package com.example.repository;


import com.example.model.PollRole;
import com.example.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PollRoleRepository extends JpaRepository<PollRole, Integer> {

//    Хэрэглэгчийн Role-оос шалтгаалж санал асуулгыг авах
    List findByUserRole(UserRole userRole);
}