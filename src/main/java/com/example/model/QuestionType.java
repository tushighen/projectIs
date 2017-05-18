package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionTypeId;

    @NotNull
    @Column(nullable = false)
    private String typeName;

    @OneToMany(mappedBy = "questionType", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "questionType")
    private Set<Question> questions;

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

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
