package org.softuni.repairShop.model.dto;

import java.util.Objects;

public final class ClientRegisterDTO {
    private  String fullName;
    private  String username;
    private  String email;
    private  String address;
    private  String password;
    private  String confirmPassword;
    private  String phoneNumber;

    public ClientRegisterDTO() {
    }

    public String getFullName() {
        return fullName;
    }

    public ClientRegisterDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ClientRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ClientRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ClientRegisterDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ClientRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public ClientRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ClientRegisterDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
