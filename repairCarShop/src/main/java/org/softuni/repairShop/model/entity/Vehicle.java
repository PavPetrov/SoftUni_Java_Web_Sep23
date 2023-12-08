package org.softuni.repairShop.model.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.softuni.repairShop.model.enums.VehicleCategoryEnum;
import org.softuni.repairShop.model.enums.EngineEnum;

@Entity
public class Vehicle extends BaseEntity {
    @Column(nullable = false)
    @Length(min = 1, max = 50)
    private String brand;
    @Column(nullable = false)
    @Length(min = 1, max = 50)
    private String model;

    @Column(nullable = false)
    private int year;
    @ManyToOne
    private Client owner;

    @Enumerated(EnumType.STRING)
    private EngineEnum engine;

    @Enumerated(EnumType.STRING)
    private VehicleCategoryEnum category;
    @Column(nullable = false)
    private String color;

    public Vehicle() {
    }

    public String getBrand() {
        return brand;
    }

    public Vehicle setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Vehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Vehicle setYear(int year) {
        this.year = year;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public Vehicle setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public VehicleCategoryEnum getCategory() {
        return category;
    }

    public Vehicle setCategory(VehicleCategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Vehicle setColor(String color) {
        this.color = color;
        return this;
    }

    public Client getOwner() {
        return owner;
    }

    public Vehicle setOwner(Client owner) {
        this.owner = owner;
        return this;
    }

    @Override
    public String toString() {
        return brand + " " + model + " " + year + " " + engine + " " + color;
    }
}
