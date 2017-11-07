package com.example.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.Set;

@Entity
@JsonIgnoreProperties(value = {"polls", "answers"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int userId;

    @NotNull
    @Column(nullable = false)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String userName;

    @NotNull
    @Column(nullable = false)
    private String password;

    @Column
    private Boolean isRequested;

    @Column Boolean isDeveloper;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRequested() {
        return isRequested;
    }

    public void setRequested(Boolean requested) {
        isRequested = requested;
    }

    public Boolean getDeveloper() {
        return isDeveloper;
    }

    public void setDeveloper(Boolean developer) {
        isDeveloper = developer;
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