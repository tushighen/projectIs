package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OptionChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int optionChoiceId;

    @NotNull
    @Column(nullable = false)
    private String choiceName;

    @ManyToOne
    @JoinColumn(name = "questionId")
    @JsonBackReference(value = "questionOptionChoice")
    @NotNull
    private Question question;

    @OneToOne(mappedBy = "optionChoice", cascade = CascadeType.ALL)
    @JsonBackReference(value = "optionChoice")
    private Answer answer;

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

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
