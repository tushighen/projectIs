package com.example.controller;

import com.example.service.OptionChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/optionchoice")
@CrossOrigin(origins = "*")
public class OptionChoiceController {

    @Autowired
    OptionChoiceService optionChoiceService;


}
