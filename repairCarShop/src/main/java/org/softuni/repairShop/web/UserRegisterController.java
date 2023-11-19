package org.softuni.repairShop.web;

import jakarta.validation.Valid;
import org.softuni.repairShop.model.dto.UserRegisterDTO;
import org.softuni.repairShop.model.enums.RoleEnum;
import org.softuni.repairShop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String register(@Valid UserRegisterDTO userRegisterDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if(!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())){
            bindingResult.addError(
                    new FieldError("differentConfirmPassword",
                            "confirmPassword",
                            "Password and Confirm password don't match"));
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO",
                    bindingResult);
            return "redirect:register";
        }

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
