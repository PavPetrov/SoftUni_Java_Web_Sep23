package org.softuni.repairShop.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.repairShop.model.dto.*;
import org.softuni.repairShop.model.entity.Client;
import org.softuni.repairShop.model.entity.Role;
import org.softuni.repairShop.model.entity.User;
import org.softuni.repairShop.model.enums.RoleEnum;
import org.softuni.repairShop.repository.UserRepository;
import org.softuni.repairShop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(UserRegisterDTO userRegisterDTO) {

        User user = modelMapper.map(userRegisterDTO, User.class);

        if (userRepository.findByUsername(user.getUsername()).isPresent()
                || userRepository.findByEmail(user.getEmail()).isPresent()) {
            return false;
        }

        userRepository.save(user);
        return true;
    }


    @Override
    public void adminInit() {
        Optional<User> optionalAdmin = userRepository.findByUsername("admin");

        List<RoleEnum> adminRoles = List.of(
                RoleEnum.ADMINISTRATOR
        );

        if (optionalAdmin.isEmpty()) {

            UserRegisterDTO adminDTO = new UserRegisterDTO()
                    .setFullName("Admin Adminov")
                    .setEmail("admin@ad.min")
                    .setUsername("admin")
                    .setUserRole(adminRoles)
                    .setPassword("12345");
            User admin = modelMapper.map(adminDTO, User.class);
            admin.setEnabled(true);
            userRepository.save(admin);
        }

    }

    @Override
    public void workersInit() {


        if (userRepository.count() < 2) {

            RoleEnum engine = RoleEnum.MECHANIC_ENGINE;
            RoleEnum tire = RoleEnum.MECHANIC_TIRES;
            RoleEnum body = RoleEnum.MECHANIC_BODY;
            RoleEnum suspension = RoleEnum.MECHANIC_SUSPENSION;


            UserRegisterDTO workerTiresDTO = new UserRegisterDTO()
                    .setFullName("Gumcho Cumchev 1")
                    .setEmail("gumcho@tire.com")
                    .setUsername("gumcho")
                    .setUserRole(List.of(tire))
                    .setPassword("12345");
            User workerTires = modelMapper.map(workerTiresDTO, User.class).setEnabled(true);

            UserRegisterDTO workerEngineDTO = new UserRegisterDTO()
                    .setFullName("Bai Ivan")
                    .setEmail("ivan@bai.h")
                    .setUsername("bai-ivan")
                    .setUserRole(List.of(engine, suspension))
                    .setPassword("12345");
            User workerEngine = modelMapper.map(workerEngineDTO, User.class).setEnabled(true);

            UserRegisterDTO workerSuspensionDTO = new UserRegisterDTO()
                    .setFullName("Drago Draganov")
                    .setEmail("darago@drag.g")
                    .setUsername("drago")
                    .setUserRole(List.of(tire, suspension))
                    .setPassword("12345");
            User workerSuspension = modelMapper.map(workerSuspensionDTO, User.class).setEnabled(true);

            UserRegisterDTO workerBodyDTO = new UserRegisterDTO()
                    .setFullName("Kit Kitov")
                    .setEmail("shkurkka@ssssh.g")
                    .setUsername("shkurka")
                    .setUserRole(List.of(body))
                    .setPassword("12345");
            User workerBody = modelMapper.map(workerBodyDTO, User.class).setEnabled(true);

            userRepository.save(workerTires);
            userRepository.save(workerEngine);
            userRepository.save(workerSuspension);
            userRepository.save(workerBody);
        }


    }

    @Override
    public User findByUsername(String username) {

        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<UserDTO> findAll() {


        List<UserDTO> users = userRepository.findAll().stream().map(user ->
                modelMapper.map(user, UserDTO.class)).toList();

        return users;

    }

    @Override
    public UserEditDTO findUserEditById(Long id) {
        UserEditDTO user = modelMapper.map(userRepository.findById(id).get(), UserEditDTO.class);
        return user;
    }

    @Override
    public void editUser(Long id, UserEditDTO userEditDTO) {
        User user = userRepository.findById(id).get();

        //TODO Validation?

        modelMapper.map(userEditDTO, user);

        userRepository.save(user);

    }


    @Override
    public void proceedActive(Long id, Boolean ctx) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEnabled(!user.getEnabled());

            userRepository.save(user);
        }

    }

    @Override
    public UserInfoDTO getUserInfo(String username) {
        return null;
    }

    @Override
    public void edit(String username, ClientInfoDTO userToEdit) {
        Optional<User> userOptional
                = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            user.setFullName(userToEdit.getFullName())
                    .setEmail(userToEdit.getEmail())
                    .setUsername(userToEdit.getUsername());

            userRepository.save(user);
        }
    }


}
