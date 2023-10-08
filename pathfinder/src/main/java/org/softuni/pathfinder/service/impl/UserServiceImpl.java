package org.softuni.pathfinder.service.impl;

import org.softuni.pathfinder.model.entity.User;
import org.softuni.pathfinder.repository.UserRepository;
import org.softuni.pathfinder.service.UserService;
import org.softuni.pathfinder.session.LoggedUser;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public User getLoggedUser() {
        return userRepository.findByUsername(loggedUser.getUsername());
    }
}
