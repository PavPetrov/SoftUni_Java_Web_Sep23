package org.softuni.repairShop.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity{
    private String fullName;
    private String username;

    private String email;

    private String password;

    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private List<Task> tasks;

    @OneToMany(mappedBy = "owner")
    private List<Vehicle> vehicles;


    public Client() {
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

}
