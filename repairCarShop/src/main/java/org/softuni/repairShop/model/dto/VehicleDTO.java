package org.softuni.repairShop.model.dto;

import jakarta.validation.constraints.Digits;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.softuni.repairShop.model.enums.EngineEnum;
import org.softuni.repairShop.model.enums.VehicleCategoryEnum;


public class VehicleDTO {
    @Length(min = 1, max = 50,
            message = "Brand name length must be between 5 and 50 characters")
    private String brand;

    @Length(min = 1, max = 50,
            message = "Model name length must be between 5 and 50 characters")
    private String model;

    @Digits(message = "Year required", integer = 4, fraction = 0)
    private int year;

    private String owner;
    @NotNull(message = "Engine type required")
    private EngineEnum engine;

    @NotNull(message = "Category  required")
    private VehicleCategoryEnum category;
    @Length(min = 3, max = 50,
            message = "Color length must be between 3 and 50 characters")
    private String color;

    private Long id;

    private Boolean deleted;

    public VehicleDTO() {
    }

    public String getBrand() {
        return brand;
    }

    public VehicleDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Long getId() {
        return id;
    }

    public VehicleDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public VehicleDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public int getYear() {
        return year;
    }

    public VehicleDTO setYear(int year) {
        this.year = year;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public VehicleDTO setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public VehicleDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public VehicleDTO setDeleted(Boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public VehicleCategoryEnum getCategory() {
        return category;
    }

    public VehicleDTO setCategory(VehicleCategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getColor() {
        return color;
    }

    public VehicleDTO setColor(String color) {
        this.color = color;
        return this;
    }
}
