package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int pollId;

    @NotNull
    @Column(nullable = false)
    private String pollName;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private Date createdDate;

    @Column
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private Date modifiedDate;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private Date startDate;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference(value = "userPoll")
    @NotNull
    private User user;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "pollQuestion")
//    @Transient
    private List<Question> questions;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
