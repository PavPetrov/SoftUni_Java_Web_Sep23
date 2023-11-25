package org.softuni.repairShop.model.dto;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

public  class ClientRegisterDTO {
    @Length(min = 5, max = 50,
            message = "Full name length must be between 5 and 50 characters")
    private  String fullName;

    @Length(min = 5, max = 50,
            message = "Username length must be between 5 and 50 characters")
    private String username;

    @Length(min = 5, max = 50,
            message = "Email length must be between 5 and 50 characters")
    @Email(message = "Must be a valid e-mail")
    private String email;

    @Length(min = 5, max = 50,
            message = "Address length must be between 5 and 50 characters")
    private  String address;

    //TODO phone number validator
    private  String phoneNumber;

    @Length(min = 5, max = 20,
            message = "Password length must be between 5 and 50 characters")
    private String password;

    @Length(min = 5, max = 20)
    private String confirmPassword;



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
