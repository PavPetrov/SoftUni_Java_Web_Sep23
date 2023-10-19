package com.likebookapp.service;

import com.likebookapp.model.Dto.UserRegistrationDTO;
import com.likebookapp.model.entity.User;

import java.util.Optional;

public interface UserService {
    void register(UserRegistrationDTO userRegistrationDTO);

    boolean findUserByUsernameAndPassword(String username, String password);
}
