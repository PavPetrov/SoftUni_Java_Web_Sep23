package org.softuni.pathfinder.web;

import org.softuni.pathfinder.service.AuthenticationService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    @GetMapping("/users/profile")
    public String profile() {
        return "profile";
    }


}
