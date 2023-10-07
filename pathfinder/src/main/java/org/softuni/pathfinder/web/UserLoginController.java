package org.softuni.pathfinder.web;

import org.softuni.pathfinder.model.dto.LoginUserDto;
import org.softuni.pathfinder.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login(){
        return "login";
    }

    @PostMapping("/users/login")
    public String login(LoginUserDto loginUserDto) {

        boolean isLogged = userService.loginUser(loginUserDto);

        return isLogged ? "redirect:/" : "redirect:/users/login";
    }

    @GetMapping("/users/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }
}
