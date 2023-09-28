package org.softuni.pathfinder.model.entity;

import jakarta.persistence.*;
import org.softuni.pathfinder.model.enums.CategoryName;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    public Category() {
    }

    @Enumerated(EnumType.STRING)
    private CategoryName name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
