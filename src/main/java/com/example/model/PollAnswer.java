package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;

@Entity
public class PollAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int pollAnswerId;

    @ManyToOne
    @JoinColumn(name = "pollId")
    @JsonBackReference(value = "pollPollAnswer")
    private Poll poll;

    @OneToMany(mappedBy = "pollAnswer", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "pollAnswer")
    @Column(nullable = false)
    @NotNull
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference(value = "userPollAnswer")
    private User user;

    @Transient
    @Null
    private String userEmail;

    public int getPollAnswerId() {
        return pollAnswerId;
    }

    public void setPollAnswerId(int pollAnswerId) {
        this.pollAnswerId = pollAnswerId;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}