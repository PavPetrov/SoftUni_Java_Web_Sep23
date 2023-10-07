package org.softuni.pathfinder.web;

import org.softuni.pathfinder.model.entity.User;
import org.softuni.pathfinder.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/profile")
    public String profile(){
        return "profile";
    }



}
