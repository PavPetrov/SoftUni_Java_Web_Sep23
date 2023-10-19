package com.likebookapp.controller;

import com.likebookapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping
    public String index(){
        boolean isLogged = currentUser.isLogged();
        return isLogged ? "home":"index";
    }

    @GetMapping("home")
    public String home(){
        boolean isLogged = currentUser.isLogged();
        return isLogged ? "home":"index";
    }
}
