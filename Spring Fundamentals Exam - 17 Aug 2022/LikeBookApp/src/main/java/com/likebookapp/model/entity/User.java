package com.likebookapp.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name ="users")
public class User extends BaseEntity {

    @Column(unique = true, nullable = false)
    public String username;

    @Column(nullable = false)
    @Size(min=3, max = 20)
    public String password;

    @Column(unique = true, nullable = false)
    @Email
    public String email;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User() {
    }
}
