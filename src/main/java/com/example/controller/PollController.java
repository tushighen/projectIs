package com.example.controller;

        import com.example.model.*;
        import com.example.service.PollService;
        import com.example.service.QuestionService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
        import java.util.List;

@RestController
@RequestMapping(value = "api/polls")
@CrossOrigin(origins = "*")
public class PollController {

    @Autowired
    PollService pollService;
    @Autowired
    QuestionService questionService;
}