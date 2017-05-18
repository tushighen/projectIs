package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;
    @NotNull
    private String questionName;

    @Null
    @Column
    private String questionDescription;

    @ManyToOne
    @JoinColumn(name = "pollId")
    @JsonBackReference(value = "pollQuestion")
    @NotNull
    private Poll poll;

    @ManyToOne
    @JoinColumn(name = "questionTypeId")
    @JsonBackReference(value = "questionType")
    @NotNull
    private QuestionType questionType;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "questionOptionChoice")
    private Set<OptionChoice> optionChoices;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Set<OptionChoice> getOptionChoices() {
        return optionChoices;
    }

    public void setOptionChoices(Set<OptionChoice> optionChoices) {
        this.optionChoices = optionChoices;
    }
}
