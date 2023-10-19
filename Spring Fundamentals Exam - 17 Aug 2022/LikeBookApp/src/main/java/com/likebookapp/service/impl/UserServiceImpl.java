package com.likebookapp.service.impl;

import com.likebookapp.model.Dto.UserLoginDTO;
import com.likebookapp.model.Dto.UserRegistrationDTO;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.UserService;
import com.likebookapp.util.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final CurrentUser currentUser;


    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void register(UserRegistrationDTO userRegistrationDTO) {

        userRepository.save(map(userRegistrationDTO));

    }

    @Override
    public boolean findUserByUsernameAndPassword(String username, String password) {
        User user = userRepository.findUserByUsername(username).orElse(null);

        if (user == null) {
            return false;
        }

        if (passwordEncoder.matches(password, user.getPassword())) {


            currentUser.setUsername(user.getUsername());
            currentUser.setId(user.getId());
            currentUser.setLogged(true);
            return true;
        }

        return false;
    }

    private User map(UserRegistrationDTO userRegistrationDTO) {
        User user = new User();

        user.setEmail(userRegistrationDTO.email);
        user.setUsername(userRegistrationDTO.username);
        user.setPassword(passwordEncoder.encode((userRegistrationDTO.password)));

        return user;
    }
}
