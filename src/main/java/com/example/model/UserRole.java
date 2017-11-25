package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userRoleId;

    @NotNull
    @Column(nullable = false)
    private String roleName;

    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "userRole")
    private Set<User> users;

//    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
//    @JsonManagedReference(value = "pollRole")
//    private Set<PollRole> pollRoles;

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

//    public Set<PollRole> getPollRoles() {
//        return pollRoles;
//    }
//
//    public void setPollRoles(Set<PollRole> pollRoles) {
//        this.pollRoles = pollRoles;
//    }


    public UserRole(String roleName) {
        this.roleName = roleName;
    }

    public UserRole() {

    }
}
