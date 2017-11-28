package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pollStatistics")
public class PollStatistics {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "poll_id")
    private int pollId;

    @Column(name = "poll_name")
    private String pollName;

    @Column(name = "question_id")
    private int questionId;

    @Column(name = "question_name")
    private String questionName;

    @Column(name = "option_choice_id")
    private int optionChoiceId;

    @Column(name = "choice_name")
    private String choiceName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}