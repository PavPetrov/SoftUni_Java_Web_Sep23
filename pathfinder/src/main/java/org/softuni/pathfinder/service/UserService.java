package org.softuni.pathfinder.service;

import org.softuni.pathfinder.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> getAll();
}
