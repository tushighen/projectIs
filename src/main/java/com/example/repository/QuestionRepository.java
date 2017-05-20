package com.example.repository;


import com.example.model.Poll;
import com.example.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List findByPoll(Poll poll);
}
