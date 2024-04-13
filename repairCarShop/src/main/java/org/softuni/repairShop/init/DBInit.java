package org.softuni.repairShop.init;

import org.softuni.repairShop.service.ClientService;
import org.softuni.repairShop.service.RepairCategoryService;
import org.softuni.repairShop.service.UserRoleService;
import org.softuni.repairShop.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final UserService userService;

    private final UserRoleService userRoleService;

    private final ClientService clientService;

    private final RepairCategoryService repairCategoryService;

    public DBInit(UserService userService, UserRoleService userRoleService, ClientService clientService, RepairCategoryService repairCategoryService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.clientService = clientService;
        this.repairCategoryService = repairCategoryService;
    }

    @Override
    public void run(String... args) throws Exception {

        userRoleService.userRoleInit();

        repairCategoryService.repairCategoryInit();

        userService.adminInit();
        userService.workersInit();
   //     clientService.clientsInit();
    }
}
