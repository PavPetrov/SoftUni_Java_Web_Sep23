package com.likebookapp.controller;

import com.likebookapp.model.Dto.UserLoginDTO;
import com.likebookapp.model.Dto.UserRegistrationDTO;
import com.likebookapp.service.UserService;
import com.likebookapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final CurrentUser currentUser;

    public UserController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping("register")
    public String register() {
        return currentUser.isLogged() ? "redirect:/": "register";
    }


    @PostMapping("register")
    public String register(@Valid UserRegistrationDTO userRegistrationDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() ||
                !userRegistrationDTO.password.equals(userRegistrationDTO.confirmPassword)) {
            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO",
                    bindingResult);

            //TODO Send message password if confirmPassword didnt match


            return "redirect:register";
        }

        userService.register(userRegistrationDTO);


        return "login";
    }

    @GetMapping("login")
    public String login(Model model) {
        if (!model.containsAttribute("isFound")) {
            model.addAttribute("isFound", true);
        }
        return "login";

    }

    @PostMapping("login")
    public String login(@Valid UserLoginDTO userLoginDTO, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        //Validation fields

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO",
                    bindingResult);
            return "redirect:login";
        }

        boolean isLogged = userService.findUserByUsernameAndPassword(
                userLoginDTO.getUsername(), userLoginDTO.getPassword());


        //Validation  User exist && password match

        if (!isLogged) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("isFound", false);
            return "redirect:login";
        }

        return isLogged ? "redirect:/home" : "redirect:login";
    }

    @ModelAttribute
    public UserRegistrationDTO userRegistrationDTO() {
        return new UserRegistrationDTO();
    }

    @ModelAttribute
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }

}
