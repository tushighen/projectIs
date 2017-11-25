package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int answerId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference(value = "userAnswer")
    private User user;

    @ManyToOne
    @JoinColumn(name = "optionChoiceId")
    @JsonBackReference(value = "optionChoice")
    @NotNull
    private OptionChoice optionChoice;

    @ManyToOne
    @JoinColumn(name = "pollAnswerId")
    @JsonBackReference(value = "pollAnswer")
    private PollAnswer pollAnswer;

    @ManyToOne
    @JoinColumn(name = "pollA")

    @Transient
    @Null
    private OptionChoice choice;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OptionChoice getOptionChoice() {
        return optionChoice;
    }

    public void setOptionChoice(OptionChoice optionChoice) {
        this.optionChoice = optionChoice;
    }

    public PollAnswer getPollAnswer() {
        return pollAnswer;
    }

    public void setPollAnswer(PollAnswer pollAnswer) {
        this.pollAnswer = pollAnswer;
    }

    public OptionChoice getChoice() {
        return choice;
    }

    public void setChoice(OptionChoice choice) {
        this.choice = choice;
    }
}