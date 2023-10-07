package org.softuni.pathfinder.service.impl;

import org.softuni.pathfinder.model.dto.LoginUserDto;
import org.softuni.pathfinder.model.dto.RegisterUserDto;
import org.softuni.pathfinder.model.entity.User;
import org.softuni.pathfinder.model.enums.UserLevel;
import org.softuni.pathfinder.repository.UserRepository;
import org.softuni.pathfinder.service.UserService;
import org.softuni.pathfinder.session.LoggedUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final LoggedUser loggedUser;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, LoggedUser loggedUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void registerUser(RegisterUserDto registerUserDto) {

        userRepository.save(map(registerUserDto));

    }

    @Override
    public boolean loginUser(LoginUserDto loginUserDto) {
        User currentUser = userRepository.findByUsername(loginUserDto.username());

        if (currentUser != null) {
            //TODO handle -> Trows IllegalArgumentException if password is not crypt with this encoder
            if (passwordEncoder.matches(loginUserDto.password(), currentUser.getPassword())) {

                loggedUser.setLogged(true);
                loggedUser.setUserLevel(UserLevel.BEGINNER);
                loggedUser.setFullName(currentUser.getFullName());
                loggedUser.setUsername(currentUser.getUsername());

               return true;
            }
        }
        return false;
    }

    @Override
    public void logout() {
        loggedUser.reset();
    }

    private User map(RegisterUserDto registerUserDto) {
        User user = new User();
        user.setUsername(registerUserDto.username());
        user.setFullName(registerUserDto.fullName());
        user.setEmail(registerUserDto.email());
        user.setAge(registerUserDto.age());
        user.setPassword(passwordEncoder.encode(registerUserDto.password()));
        user.setLevel(UserLevel.BEGINNER);
        return user;
    }


}
