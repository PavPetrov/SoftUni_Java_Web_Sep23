package org.softuni.pathfinder.model.entity;

import jakarta.persistence.*;
import org.softuni.pathfinder.model.enums.UserLevel;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    public User() {
    }

    private int age;
    @Column(name ="username", nullable = false)
    private String username;
    @Column(name ="password", nullable = false)
    private String password;

    @Column(name ="full_name", nullable = false)
    private String fullName;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserLevel level;
    @ManyToMany
    private Set<Role> roles;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}