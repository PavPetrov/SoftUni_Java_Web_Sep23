package org.softuni.repairShop.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.repairShop.model.dto.UserRegisterDTO;
import org.softuni.repairShop.model.entity.User;
import org.softuni.repairShop.model.enums.RoleEnum;
import org.softuni.repairShop.repository.UserRepository;
import org.softuni.repairShop.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {

     //   User user = mapUser(userRegisterDTO);
        User user= modelMapper.map(userRegisterDTO, User.class);



        userRepository.save(user);
    }


    private User mapUser(UserRegisterDTO userRegisterDTO) {

        return new User()
                .setFullName(userRegisterDTO.getFullName())
                .setUsername(userRegisterDTO.getUsername())
                .setEmail(userRegisterDTO.getEmail())
                .setUserRole(userRegisterDTO.getUserRole())
                //         .setUserRoles(userRegisterDTO.getUserRoles())
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
    }

    @Override
    public void adminInit() {
        Optional<User> optionalAdmin = userRepository.findByUsername("admin");

//        List<UserRole> userRoles = new ArrayList<>(List.of(new UserRole().setUserRole(RoleEnum.ADMINISTRATOR)));
//        userRoles.add(new UserRole().setUserRole(RoleEnum.ADMINISTRATOR));

        if (optionalAdmin.isEmpty()) {

            User admin = new User()
                    .setFullName("Admin Adminov")
                    .setEmail("admin@ad.min")
                    .setUsername("admin")
                    //        .setUserRoles(userRoles)
                    .setUserRole(RoleEnum.ADMINISTRATOR)
                    .setPassword(passwordEncoder.encode("12345"))
                    .setActive(true);
            userRepository.save(admin);
        }

    }

    @Override
    public void workersInit() {


        if (userRepository.count() < 2) {

            User workerTires = new User()
                    .setFullName("Gumcho Cumchev 1")
                    .setEmail("gumcho@tire.com")
                    .setUsername("gumcho")
                    .setPassword("1234")
                    .setUserRole(RoleEnum.MECHANIC_TIRE)
//                    .setUserRoles(new ArrayList<>(List.of(new UserRole().setUserRole(RoleEnum.MECHANIC_TIRE),
//                            new UserRole().setUserRole(RoleEnum.MECHANIC_BODY)
//                    )))
                    .setPassword(passwordEncoder.encode("1234"))
                    .setActive(true);

            User workerEngine = new User()
                    .setFullName("Ivan Ivanov 1")
                    .setEmail("ivan@gmail.com")
                    .setUsername("ivan56")
                    .setUserRole(RoleEnum.MECHANIC_ENGINE)
                    .setPassword(passwordEncoder.encode("1234"))
                    .setActive(true);

            User workerSuspension = new User()
                    .setFullName("Pesho Petrov 1")
                    .setEmail("pesho@gmail.com")
                    .setUsername("pesho_p")
                    .setUserRole(RoleEnum.MECHANIC_SUSPENSION)
                    .setPassword(passwordEncoder.encode("1234"))
                    .setActive(true);

            User workerBody = new User()
                    .setFullName("Gosho Petrov 1")
                    .setEmail("gosho@gmail.com")
                    .setUsername("gosho")
                    .setUserRole(RoleEnum.MECHANIC_BODY)
                    .setPassword(passwordEncoder.encode("1234"))
                    .setActive(true);

            userRepository.save(workerTires);
            userRepository.save(workerEngine);
            userRepository.save(workerSuspension);
            userRepository.save(workerBody);
        }


    }

}
