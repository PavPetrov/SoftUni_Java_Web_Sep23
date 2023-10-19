package com.likebookapp.model.Dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginDTO {
    @Size(min = 3, max = 20, message = "!Username length between 3 and 20!")
    @NotNull
    private String username;
    @Size(min = 3, max = 20, message = "!Password length between 3 and 20!")
    private String password;


    public String getUsername() {
        return username;
    }

    public UserLoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
