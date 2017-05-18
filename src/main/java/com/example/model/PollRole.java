package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class PollRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int pollRoleId;

    @OneToOne
    @JoinColumn(name = "pollId")
    @JsonBackReference(value = "poll")
    @NotNull
    private Poll poll;

    @ManyToOne
    @JoinColumn(name = "userRoleId")
    @JsonBackReference(value = "pollRole")
    @NotNull
    private UserRole userRole;

    public int getPollRoleId() {
        return pollRoleId;
    }

    public void setPollRoleId(int pollRoleId) {
        this.pollRoleId = pollRoleId;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}