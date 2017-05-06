package com.example.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.Set;

@Entity
//@JsonIgnoreProperties(value = {"polls", "answers"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @NotNull
    private String email;
    private String code;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Date dateOfBirth;
    @NotNull
    private String sex;
    @NotNull
    private String password;

    @ManyToOne
    @JoinColumn(name = "userRoleId")
    @JsonBackReference(value = "userRole")
    @NotNull
    private UserRole userRole;

    @ManyToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "userPoll")
    private Set<Poll> polls;

    @ManyToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "userAnswer")
    private Set<Answer> answers;

//    @Transient
//    private int userRoleId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Set<Poll> getPolls() {
        return polls;
    }

    public void setPolls(Set<Poll> polls) {
        this.polls = polls;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}