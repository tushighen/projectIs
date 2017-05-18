package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int pollId;

    @NotNull
    @Column(nullable = false)
    private String pollName;

    @NotNull
    @Column(nullable = false)
    private Date createdDate;

    @Null
    @Column
    private Date modifiedDate;

    @NotNull
    @Column(nullable = false)
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference(value = "userPoll")
    @NotNull
    private User user;

    @OneToOne(mappedBy = "poll", cascade = CascadeType.ALL)
    @JsonBackReference(value = "poll")
    @Null
    private PollRole pollRole;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
    @JsonBackReference(value = "pollQuestion")
    @Null
    private Set<Question> questions;

    @Transient
    private ArrayList<Integer> userRoleId;

    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    public String getPollName() {
        return pollName;
    }

    public void setPollName(String pollName) {
        this.pollName = pollName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PollRole getPollRole() {
        return pollRole;
    }

    public void setPollRole(PollRole pollRole) {
        this.pollRole = pollRole;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Integer> getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(ArrayList<Integer> userRoleId) {
        this.userRoleId = userRoleId;
    }
}
