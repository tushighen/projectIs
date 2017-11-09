package com.example.controller;

import com.example.model.OptionChoice;
import com.example.service.OptionChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/optionchoice")
@CrossOrigin(origins = "*")
public class OptionChoiceController {

    @Autowired
    OptionChoiceService optionChoiceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List getAllChoice() {
        return optionChoiceService.getAllChoice();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public OptionChoice addChoice(@RequestBody OptionChoice choice) {
        return optionChoiceService.addChoice(choice);
    }
}