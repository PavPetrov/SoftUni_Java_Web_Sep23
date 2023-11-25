package org.softuni.repairShop.init;

import org.softuni.repairShop.service.ClientService;
import org.softuni.repairShop.service.UserRoleService;
import org.softuni.repairShop.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final UserService userService;

    private final UserRoleService userRoleService;

    private final ClientService clientService;

    public DBInit(UserService userService, UserRoleService userRoleService, ClientService clientService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.clientService = clientService;
    }

    @Override
    public void run(String... args) throws Exception {

        userRoleService.userRoleInit();

        userService.adminInit();
        userService.workersInit();
        clientService.clientsInit();
    }
}
