package com.likebookapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity()
public class Mood extends BaseEntity {

    @Enumerated(EnumType.STRING)
    public MoodEnum name;

    @Column()
    public String description;

    public Mood() {
    }

    public MoodEnum getName() {
        return name;
    }

    public Mood setName(MoodEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Mood setDescription(String description) {
        this.description = description;
        return this;
    }
}
