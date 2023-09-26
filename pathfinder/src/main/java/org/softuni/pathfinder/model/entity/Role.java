package org.softuni.pathfinder.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.softuni.pathfinder.model.enums.RoleName;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    public Role() {
    }

    @Enumerated(EnumType.STRING)
    private RoleName name;

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
