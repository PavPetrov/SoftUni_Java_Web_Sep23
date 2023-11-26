package org.softuni.repairShop.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.softuni.repairShop.model.entity.Role;
import org.softuni.repairShop.model.enums.RoleEnum;

import java.util.List;


public class UserRegisterDTO {
    @Length(min = 5, max = 50,
            message = "Full name length must be between 5 and 50 characters")
    private String fullName;

    @Length(min = 5, max = 50,
            message = "Username length must be between 5 and 50 characters")
    private String username;

    @Length(min = 5, max = 50,
            message = "Email length must be between 5 and 50 characters")
    @Email(message = "Must be a valid e-mail")
    private String email;

    @Length(min = 5, max = 20,
            message = "Password length must be between 5 and 50 characters")
    private String password;

    @Length(min = 5, max = 20)
    private String confirmPassword;

    @NotNull(message = "Occupation required")
    private List<RoleEnum> userRole;

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


    public List<RoleEnum> getUserRole() {
        return userRole;
    }

    public UserRegisterDTO setUserRole(List<RoleEnum> userRole) {
        this.userRole = userRole;
        return this;
    }
}
