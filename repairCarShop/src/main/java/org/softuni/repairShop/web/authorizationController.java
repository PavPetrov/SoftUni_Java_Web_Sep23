package org.softuni.repairShop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class authorizationController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login/error")
    public String onFailure(Model model, @ModelAttribute("username") String username) {

        model.addAttribute("username", username);
        model.addAttribute("badCredentials", true);
        return "login";
    }

}
