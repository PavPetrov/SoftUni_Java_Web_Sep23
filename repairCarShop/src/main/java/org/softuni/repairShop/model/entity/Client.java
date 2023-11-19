package org.softuni.repairShop.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity{

    @Column(nullable = false)
    @Length(min = 5, max=50)
    private String fullName;

    @Column(nullable = false, unique = true)
    @Length(min = 5, max=20)
    private String username;

    @Column(nullable = false, unique = true)
    @Length(min = 5, max=50)
    private String email;

    @Column(nullable = false)
    @Length(min = 5, max=20)
    private String password;

    @Length(max=20)
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
