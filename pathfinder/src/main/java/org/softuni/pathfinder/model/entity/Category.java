package org.softuni.pathfinder.model.entity;

import jakarta.persistence.*;
import org.softuni.pathfinder.model.enums.CategoryEnum;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    public Category() {
    }

    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;


    public CategoryEnum getName() {
        return name;
    }

    public Category setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
