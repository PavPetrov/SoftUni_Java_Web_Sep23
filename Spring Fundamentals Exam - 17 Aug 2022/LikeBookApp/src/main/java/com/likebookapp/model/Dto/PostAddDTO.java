package com.likebookapp.model.Dto;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.MoodEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostAddDTO {

    private Long id;

    @Size(min = 2, max = 150,message = "!Content length must be between 2 and 150!")
    private String content;

    @NotNull(message = "!Field cannot be empty!")
    private MoodEnum mood;

    public PostAddDTO() {
    }

    public String getContent() {
        return content;
    }

    public PostAddDTO setContent(String content) {
        this.content = content;
        return this;
    }

    public MoodEnum getMood() {
        return mood;
    }

    public PostAddDTO setMood(MoodEnum mood) {
        this.mood = mood;
        return this;
    }

    public Long getId() {
        return id;
    }

    public PostAddDTO setId(Long id) {
        this.id = id;
        return this;
    }
}
