package org.softuni.repairShop.model.entity;

import jakarta.persistence.*;
import org.softuni.repairShop.model.enums.RoleEnum;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleEnum userRole;


    public Role() {
    }

    public RoleEnum getUserRole() {
        return userRole;
    }

    public Role setUserRole(RoleEnum userRole) {
        this.userRole = userRole;
        return this;
    }

}
