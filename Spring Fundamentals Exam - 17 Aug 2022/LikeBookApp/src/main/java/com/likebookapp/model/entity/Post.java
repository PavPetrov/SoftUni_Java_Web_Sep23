package com.likebookapp.model.entity;

import org.springframework.data.repository.cdi.Eager;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    @Column(nullable = false)
    @Size(min=2, max =150)
    public String content;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToMany
    private List<User> userLikes;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mood mood;

    public Post() {
    }

    public String getContent() {
        return content;
    }

    public Post setContent(String content) {
        this.content = content;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Post setUser(User user) {
        this.user = user;
        return this;
    }

    public List<User> getUserLikes() {
        return userLikes;
    }

    public Post setUserLikes(List<User> userLikes) {
        this.userLikes = userLikes;
        return this;
    }

    public Mood getMood() {
        return mood;
    }

    public Post setMood(Mood mood) {
        this.mood = mood;
        return this;
    }
}
