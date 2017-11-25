package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PollAnswerRepository extends JpaRepository<com.example.model.PollAnswer, Integer> {
}