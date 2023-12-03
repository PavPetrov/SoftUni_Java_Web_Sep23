package org.softuni.repairShop.service.impl;

import org.softuni.repairShop.model.entity.Role;
import org.softuni.repairShop.model.enums.RoleEnum;
import org.softuni.repairShop.repository.UserRoleRepository;
import org.softuni.repairShop.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void userRoleInit() {

        if (userRoleRepository.count() == 0) {
            Arrays.stream(RoleEnum.values()).forEach(role -> {
                Role userRole = new Role();
                userRole.setUserRole(role);
                userRoleRepository.save(userRole);
            });
        }

    }
}
