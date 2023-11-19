package org.softuni.repairShop.web;

import org.softuni.repairShop.model.dto.UserRegisterDTO;
import org.softuni.repairShop.model.enums.RoleEnum;
import org.softuni.repairShop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserRegisterController {
    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(UserRegisterDTO userRegisterDTO){

        userService.register(userRegisterDTO);

        return "index";
    }

    @ModelAttribute
    public RoleEnum[] roles(){
        return RoleEnum.values();
    }

    @ModelAttribute
    public UserRegisterDTO userRegisterDTO(){
        return new UserRegisterDTO();
    }
}
