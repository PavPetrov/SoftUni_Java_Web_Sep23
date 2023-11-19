package org.softuni.repairShop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.softuni.repairShop.model.enums.RoleEnum;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false)
    @Length(min = 5, max = 50)
    private String fullName;

    @Column(nullable = false, unique = true)
    @Length(min = 5, max=20)
    private String username;

    @Column(nullable = false, unique = true)
    @Length(min = 5, max=50)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;
    private Boolean isActive;

    @Enumerated(EnumType.STRING)
    private RoleEnum userRole;

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


    public Boolean getActive() {
        return isActive;
    }

    public User setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public RoleEnum getUserRole() {
        return userRole;
    }

    public User setUserRole(RoleEnum userRole) {
        this.userRole = userRole;
        return this;
    }
}
