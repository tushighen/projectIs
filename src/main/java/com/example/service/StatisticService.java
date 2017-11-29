package com.example.service;

import com.example.repository.MaxChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {

    @Autowired
    MaxChoiceRepository maxChoiceRepository;

    public List getMaxChoice(int id) {
        return maxChoiceRepository.findByPollId(id);
    }
}
