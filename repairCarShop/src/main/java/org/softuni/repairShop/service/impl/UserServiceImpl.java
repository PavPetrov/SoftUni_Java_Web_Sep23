package org.softuni.repairShop.service.impl;

import org.softuni.repairShop.model.dto.UserRegisterDTO;
import org.softuni.repairShop.model.entity.User;
import org.softuni.repairShop.model.enums.RoleEnum;
import org.softuni.repairShop.repository.UserRepository;
import org.softuni.repairShop.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {

        User user =mapUser(userRegisterDTO);

        userRepository.save(user);
    }



    private User mapUser(UserRegisterDTO userRegisterDTO) {

        return new User()
                .setFullName(userRegisterDTO.getFullName())
                .setUsername(userRegisterDTO.getUsername())
                .setEmail(userRegisterDTO.getEmail())
                .setRoles(userRegisterDTO.getRoles())
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
    }

    @Override
    public void adminInit() {
        Optional<User> optionalAdmin = userRepository.findByUsername("admin");

        if(optionalAdmin.isEmpty()){

            User admin = new User()
                    .setFullName("Admin Adminov")
                    .setEmail("admin@ad.min")
                    .setUsername("admin")
                    .setRoles(new ArrayList<>(List.of(RoleEnum.ADMINISTRATOR)))
                    .setPassword(passwordEncoder.encode("adm!n"))
                    .setActive(true);

            userRepository.save(admin);
        }

    }
}
