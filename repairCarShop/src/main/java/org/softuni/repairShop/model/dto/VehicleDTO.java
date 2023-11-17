package org.softuni.repairShop.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import org.softuni.repairShop.model.entity.Client;
import org.softuni.repairShop.model.enums.EngineEnum;
import org.softuni.repairShop.model.enums.VehicleCategoryEnum;

public class VehicleDTO {
    private String brand;

    private String model;

    private int year;

    private Client owner;

    private EngineEnum engine;

    private VehicleCategoryEnum category;

    private String color;

    public VehicleDTO() {
    }

    public String getBrand() {
        return brand;
    }

    public VehicleDTO setBrand(String brand) {
        this.brand = brand;
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

    public Client getOwner() {
        return owner;
    }

    public VehicleDTO setOwner(Client owner) {
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
