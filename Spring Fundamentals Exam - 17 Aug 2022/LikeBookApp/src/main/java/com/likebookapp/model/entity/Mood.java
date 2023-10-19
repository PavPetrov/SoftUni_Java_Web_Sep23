package com.likebookapp.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity()
public class Mood extends BaseEntity {

    @Enumerated(EnumType.STRING)
    public MoodEnum moodsName;

    @Column()
    public String description;

    @OneToMany(mappedBy = "mood")
    private Set<Post> posts;

    public Mood() {
    }

    public String getDescription() {
        return description;
    }

    public Mood setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public Mood setPosts(Set<Post> posts) {
        this.posts = posts;
        return this;
    }

    public MoodEnum getMoodsName() {
        return moodsName;
    }

    public Mood setMoodsName(MoodEnum moodsName) {
        this.moodsName = moodsName;
        return this;
    }
}
