package com.example.repository;

import com.example.model.GeneralStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneralStatisticsRepository extends JpaRepository<GeneralStatistics, Integer> {
    List findByPollId(int id);
}
