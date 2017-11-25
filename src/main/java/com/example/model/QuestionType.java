package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "questionTypeId")
public class QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionTypeId;

    @NotNull
    @Column(nullable = false)
    private String typeName;

    @OneToMany(mappedBy = "questionType", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "questionType")
    private List<Question> questions;

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public QuestionType(String typeName) {
        this.typeName = typeName;
    }

    public QuestionType() {

    }
}