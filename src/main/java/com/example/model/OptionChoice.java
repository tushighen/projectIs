package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class OptionChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int optionChoiceId;

    @NotNull
    @Column(nullable = false)
    private String choiceName;

    @Column
    private Boolean isCustom;

    @ManyToOne
    @JoinColumn(name = "questionId")
    @JsonBackReference(value = "questionOptionChoice")
    @NotNull
    private Question question;

    @OneToMany(mappedBy = "optionChoice", cascade = CascadeType.ALL)
    @JsonBackReference(value = "optionChoice")
    private List<Answer> answers;

    public int getOptionChoiceId() {
        return optionChoiceId;
    }

    public void setOptionChoiceId(int optionChoiceId) {
        this.optionChoiceId = optionChoiceId;
    }

    public String getChoiceName() {
        return choiceName;
    }

    public void setChoiceName(String choiceName) {
        this.choiceName = choiceName;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Boolean getCustom() {
        return isCustom;
    }

    public void setCustom(Boolean custom) {
        isCustom = custom;
    }
}