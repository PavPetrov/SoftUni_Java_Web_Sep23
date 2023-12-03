package org.softuni.repairShop.service;

import org.softuni.repairShop.model.dto.UserRegisterDTO;
import org.softuni.repairShop.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    void register(UserRegisterDTO userRegisterDTO);

    void adminInit();

    void workersInit();

    User findByUsername(String user);
}
