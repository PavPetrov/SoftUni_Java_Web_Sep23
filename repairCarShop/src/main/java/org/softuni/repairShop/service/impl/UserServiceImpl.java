package org.softuni.repairShop.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.repairShop.model.dto.UserRegisterDTO;
import org.softuni.repairShop.model.entity.User;
import org.softuni.repairShop.model.enums.RoleEnum;
import org.softuni.repairShop.repository.UserRepository;
import org.softuni.repairShop.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    public void register(UserRegisterDTO userRegisterDTO) {

        User user = modelMapper.map(userRegisterDTO, User.class);

        userRepository.save(user);
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
            admin.setActive(true);
            userRepository.save(admin);
        }

    }

    @Override
    public void workersInit() {


        if (userRepository.count() < 2) {

            RoleEnum engine = RoleEnum.MECHANIC_ENGINE;
            RoleEnum tire = RoleEnum.MECHANIC_TIRE;
            RoleEnum body = RoleEnum.MECHANIC_BODY;
            RoleEnum suspension = RoleEnum.MECHANIC_SUSPENSION;


            UserRegisterDTO workerTiresDTO = new UserRegisterDTO()
                    .setFullName("Gumcho Cumchev 1")
                    .setEmail("gumcho@tire.com")
                    .setUsername("gumcho")
                    .setUserRole(List.of(tire))
                    .setPassword("12345");
            User workerTires = modelMapper.map(workerTiresDTO, User.class).setActive(true);

            UserRegisterDTO workerEngineDTO = new UserRegisterDTO()
                    .setFullName("Bai Ivan")
                    .setEmail("ivan@bai.h")
                    .setUsername("bai-ivan")
                    .setUserRole(List.of(engine, suspension))
                    .setPassword("12345");
            User workerEngine = modelMapper.map(workerEngineDTO, User.class).setActive(true);

            UserRegisterDTO workerSuspensionDTO = new UserRegisterDTO()
                    .setFullName("Drago Draganov")
                    .setEmail("darago@drag.g")
                    .setUsername("drago")
                    .setUserRole(List.of(tire, suspension))
                    .setPassword("12345");
            User workerSuspension = modelMapper.map(workerSuspensionDTO, User.class).setActive(true);

            UserRegisterDTO workerBodyDTO = new UserRegisterDTO()
                    .setFullName("Kit Kitov")
                    .setEmail("shkurkka@ssssh.g")
                    .setUsername("shkurka")
                    .setUserRole(List.of(body))
                    .setPassword("12345");
            User workerBody = modelMapper.map(workerBodyDTO, User.class).setActive(true);

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


}
