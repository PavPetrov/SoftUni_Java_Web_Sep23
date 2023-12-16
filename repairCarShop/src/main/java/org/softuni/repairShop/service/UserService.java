package org.softuni.repairShop.service;

import org.softuni.repairShop.model.dto.*;
import org.softuni.repairShop.model.entity.User;

import java.util.List;

public interface UserService {
    boolean register(UserRegisterDTO userRegisterDTO);

    void adminInit();

    void workersInit();

    User findByUsername(String user);


    List<UserDTO> findAll();

    UserEditDTO findUserEditById(Long id);

    void editUser(Long id, UserEditDTO userEditDTO);

    void proceedActive(Long id, Boolean ctx);

    UserInfoDTO getUserInfo(String username);

    void edit(String username, UserInfoDTO userInfoDTO);

    UserInfoDTO getInfo(String username);

    User findByEmail(String emailToEdit);
}
