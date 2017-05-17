package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.Set;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pollId;
    @NotNull
    private String pollName;
    @NotNull
    private Date createdDate;
    @Null
    private Date modifiedDate;
//    @NotNull
//    private int createdBy;
    @NotNull
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

//    public int getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(int createdBy) {
//        this.createdBy = createdBy;
//    }

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
}
