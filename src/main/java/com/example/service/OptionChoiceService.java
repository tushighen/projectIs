package com.example.service;

import com.example.model.OptionChoice;
import com.example.repository.OptionChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionChoiceService {

    @Autowired
    OptionChoiceRepository optionChoiceRepository;

    public List getAllChoice() {
        return optionChoiceRepository.findAll();
    }

    public OptionChoice addChoice(OptionChoice choice) {
        return optionChoiceRepository.save(choice);
    }
}
