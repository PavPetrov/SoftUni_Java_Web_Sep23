package org.softuni.repairShop.model.dto;

import org.softuni.repairShop.model.enums.RoleEnum;

import java.util.List;

public class UserRegisterDTO {

    private String fullName;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String phoneNumber;
    private List<RoleEnum> roles;

    public UserRegisterDTO() {
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public UserRegisterDTO setRoles(List<RoleEnum> roles) {
        this.roles = roles;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }



    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserRegisterDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }


}
