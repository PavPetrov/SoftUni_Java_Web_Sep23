package org.softuni.repairShop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import org.hibernate.validator.constraints.Length;
import org.softuni.repairShop.model.enums.RoleEnum;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity {

    @Column(nullable = false)
    @Length(min = 5, max = 50)
    private String fullName;

    @Column(nullable = false, unique = true)
    @Length(min = 5, max = 20)
    private String username;

    @Column(nullable = false, unique = true)
    @Length(min = 5, max = 50)
    private String email;

    private String address;

    @Column(nullable = false)
    private String password;

    @Length(max = 20) //TODO phone number validator
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private List<Task> tasks = new ArrayList<>();

    @OneToMany(mappedBy = "owner")
    private List<Vehicle> vehicles = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private RoleEnum role;


    public Client() {
        this.role = RoleEnum.CLIENT;
    }

    public String getFullName() {
        return fullName;
    }

    public Client setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Client setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Client setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Client setAddress(String address) {
        this.address = address;
        return this;
    }

    public Client setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Client setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        return this;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Client setTasks(List<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public RoleEnum getRole() {
        return role;
    }

    public Client setRole(RoleEnum role) {
        this.role = role;
        return this;
    }
}
