package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int answerId;

    @Null
    @Column
    private String answerText;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference(value = "userAnswer")
    @NotNull
    private User user;

    @OneToOne
    @JoinColumn(name = "optionChoiceId")
    @JsonBackReference(value = "optionChoice")
    @NotNull
    private OptionChoice optionChoice;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
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
}