package org.softuni.repairShop.web;

import org.softuni.repairShop.model.dto.ClientRegisterDTO;
import org.softuni.repairShop.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients")
public class ClientRegisterController {

    private final ClientService clientService;

    public ClientRegisterController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/register")
    public String register(){
        return "clients_register";
    }

    @PostMapping("/register")
    public String register(ClientRegisterDTO clientRegisterDTO){

        clientService.register(clientRegisterDTO);

        return "index";
    }
}
