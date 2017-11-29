package com.example.repository;

import com.example.model.MaxChoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaxChoiceRepository extends JpaRepository<MaxChoice, Integer> {
    List findByPollId(int id);
}
