package org.softuni.repairShop.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import org.softuni.repairShop.model.enums.RoleEnum;

import java.util.List;

@Entity
public class User extends BaseEntity{

    private String fullName;
    private String username;
    private String email;
    private String password;
    private Boolean isActive;

    @Enumerated(EnumType.STRING)
    private List<RoleEnum> roles;

    @OneToMany
    private List<Task> tasks;

    public User() {
        this.isActive = false;
    }


    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public User setTasks(List<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public User setRoles(List<RoleEnum> roles) {
        this.roles = roles;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public User setActive(Boolean active) {
        isActive = active;
        return this;
    }
}
