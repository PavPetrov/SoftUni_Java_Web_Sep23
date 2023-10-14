package com.likebookapp.model.entity;

public enum MoodEnum {
    HAPPY ("Hapy"),
    SAD ("Sad"),
    INSPIRED ("Inspired");

    private String value;

    private MoodEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
