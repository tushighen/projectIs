package com.example;

import com.example.model.QuestionType;
import com.example.model.UserRole;
import com.example.repository.QuestionTypeRepository;
import com.example.repository.UserRoleRepository;
import com.example.service.UserRoleService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    QuestionTypeRepository questionTypeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            userRoleRepository.save(new UserRole("user"));
            questionTypeRepository.save(new QuestionType("radio"));
            questionTypeRepository.save(new QuestionType("check"));
        };
    }
}