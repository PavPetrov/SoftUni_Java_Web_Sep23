package org.softuni.pathfinder.service;

import org.softuni.pathfinder.model.dto.LoginUserDto;
import org.softuni.pathfinder.model.dto.RegisterUserDto;
import org.softuni.pathfinder.model.entity.User;

import java.util.List;


public interface UserService {

    List<User> getAll();

    void registerUser(RegisterUserDto registerUserDto);

    boolean loginUser(LoginUserDto loginUserDto);

    void logout();
}
