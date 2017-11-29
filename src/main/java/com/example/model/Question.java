package com.example.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Set;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "questionTypeId", scope = QuestionType.class)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;

    @NotNull
    private String questionName;

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
//    @JsonSerialize
    private QuestionType questionType;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "questionOptionChoice")
    private List<OptionChoice> optionChoices;

    @Transient
    @Null
    private String type;

    @Transient
    @Null
    private List<GeneralStatistics> generalStatistics;

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

    public List<OptionChoice> getOptionChoices() {
        return optionChoices;
    }

    public void setOptionChoices(List<OptionChoice> optionChoices) {
        this.optionChoices = optionChoices;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<GeneralStatistics> getGeneralStatistics() {
        return generalStatistics;
    }

    public void setGeneralStatistics(List<GeneralStatistics> generalStatistics) {
        this.generalStatistics = generalStatistics;
    }
}