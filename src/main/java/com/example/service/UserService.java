package com.example.service;

import com.example.model.User;
import com.example.model.UserRole;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List getAllUser() {
        List<User> users = userRepository.findAll();
        List<Map> models = new ArrayList<>();
        String role;
        for (User user: users) {
            Map<String,Object> model = new HashMap<>();
            model.put("id", user.getUserId());
            model.put("email", user.getEmail());
            model.put("code", user.getCode());
            model.put("firstName", user.getFirstName());
            model.put("lastName", user.getLastName());
            model.put("dateOfBirth", user.getDateOfBirth());
            model.put("sex", user.getSex());
            model.put("password", user.getPassword());
            role = user.getUserRole().getRoleName();
            model.put("role", role);
            models.add(model);
        }
//        for (int i = 0; i < users.size(); i++) {
//            Map<String,Object> model = new HashMap<>();
//            model.put("id", users.get(i).getUserId());
//            model.put("email", users.get(i).getEmail());
//            model.put("code", users.get(i).getCode());
//            model.put("firstName", users.get(i).getFirstName());
//            model.put("lastName", users.get(i).getLastName());
//            model.put("dateOfBirth", users.get(i).getDateOfBirth());
//            model.put("sex", users.get(i).getSex());
//            model.put("password", users.get(i).getPassword());
//            role = users.get(i).getUserRole().getRoleName();
//            model.put("role", role);
//            models.add(model);
//        }
        return models;
    }

    public User getUser(int id) {
        User user = userRepository.findOne(id);
        return user;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void editUser(User user) {
        userRepository.save(user);
    }

    public void removeStudent(int id) {
        userRepository.delete(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
}