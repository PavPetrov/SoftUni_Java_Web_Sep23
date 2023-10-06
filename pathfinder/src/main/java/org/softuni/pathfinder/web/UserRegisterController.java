package org.softuni.pathfinder.web;

import org.softuni.pathfinder.model.dto.RegisterUserDto;
import org.softuni.pathfinder.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserRegisterController {

    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String register(){
        return "register";
    }

    @PostMapping("/users/register")
    public String register(RegisterUserDto registerUserDto) {
        userService.registerUser(registerUserDto);
        return "redirect:login";
    }
}
