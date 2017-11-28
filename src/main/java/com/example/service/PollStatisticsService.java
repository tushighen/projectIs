package com.example.service;

import com.example.model.PollStatistics;
import com.example.repository.GeneralStatisticsRepository;
import com.example.repository.PollStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PollStatisticsService {

    @Autowired
    PollStatisticsRepository pollStatisticsRepository;
    @Autowired
    GeneralStatisticsRepository generalStatisticsRepository;

    public List getStat(int id) {
        return pollStatisticsRepository.findByPollId(id);

    }

    public List getGeneralStat(int id) {
        return generalStatisticsRepository.findByPollId(id);
    }
}