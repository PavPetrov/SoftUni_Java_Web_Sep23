package org.softuni.repairShop.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.softuni.repairShop.model.enums.RepairCategoryEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    @ManyToOne
    private Vehicle vehicle;

    private LocalDateTime created;

    private Boolean approved;

    private Boolean completed;

    @Enumerated(EnumType.STRING)
    private RepairCategoryEnum repairCategory;

    @ManyToOne
    @JsonManagedReference

    private Client owner;

    public Task() {
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Task setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Task setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public Boolean getApproved() {
        return approved;
    }

    public Task setApproved(Boolean approved) {
        this.approved = approved;
        return this;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public Task setCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }

    public RepairCategoryEnum getRepairCategory() {
        return repairCategory;
    }

    public Task setRepairCategory(RepairCategoryEnum repairCategory) {
        this.repairCategory = repairCategory;
        return this;
    }

    public Client getOwner() {
        return owner;
    }

    public Task setOwner(Client owner) {
        this.owner = owner;
        return this;
    }
}
