package org.softuni.repairShop.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.softuni.repairShop.model.entity.Vehicle;
import org.softuni.repairShop.model.enums.RepairCategoryEnum;

import java.time.LocalDateTime;

public class TaskDTO {
    private Long id;
    private Long vehicleId;
    private String vehicleCategory;
    private String vehicleModel;
    private String vehicleBrand;
    private String vehicleColor;
    private int vehicleYear;
    private String createdDate;

    private String completeDate;

    private String completeByUsername;

    private Boolean approved;
    private Boolean completed;

    @Enumerated(EnumType.STRING)
    private RepairCategoryEnum repairCategory;

    private Long ownerId;

    private String ownerName;

    public TaskDTO() {
    }

    public Long getId() {
        return id;
    }

    public TaskDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public Boolean getApproved() {
        return approved;
    }

    public TaskDTO setApproved(Boolean approved) {
        this.approved = approved;
        return this;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public TaskDTO setCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }

    public RepairCategoryEnum getRepairCategory() {
        return repairCategory;
    }

    public TaskDTO setRepairCategory(RepairCategoryEnum repairCategory) {
        this.repairCategory = repairCategory;
        return this;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public TaskDTO setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public TaskDTO setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public TaskDTO setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
        return this;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public TaskDTO setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
        return this;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public TaskDTO setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
        return this;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public TaskDTO setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
        return this;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public TaskDTO setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public TaskDTO setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public TaskDTO setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public String getUserName() {
        return completeByUsername;
    }

    public TaskDTO setUserName(String userName) {
        this.completeByUsername = userName;
        return this;
    }

    public String getCompletedDate() {
        return completeDate;
    }

    public TaskDTO setCompletedDate(String completedDate) {
        this.completeDate = completedDate;
        return this;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public TaskDTO setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
        return this;
    }
}
