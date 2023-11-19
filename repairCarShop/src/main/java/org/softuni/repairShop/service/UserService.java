package org.softuni.repairShop.service;

import org.softuni.repairShop.model.dto.UserRegisterDTO;

public interface UserService {
    void register(UserRegisterDTO userRegisterDTO);

    void adminInit();

    void workersInit();

}
