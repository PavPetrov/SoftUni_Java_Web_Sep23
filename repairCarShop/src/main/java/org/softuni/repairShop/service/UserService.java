package org.softuni.repairShop.service;

import org.softuni.repairShop.model.dto.UserDTO;
import org.softuni.repairShop.model.dto.UserRegisterDTO;
import org.softuni.repairShop.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    boolean register(UserRegisterDTO userRegisterDTO);

    void adminInit();

    void workersInit();

    User findByUsername(String user);


    List<UserDTO> findAll();
}
