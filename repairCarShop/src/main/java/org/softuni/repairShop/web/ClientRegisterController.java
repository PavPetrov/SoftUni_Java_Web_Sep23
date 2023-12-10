package org.softuni.repairShop.web;

import jakarta.validation.Valid;
import org.softuni.repairShop.model.dto.ClientRegisterDTO;
import org.softuni.repairShop.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/clients")
public class ClientRegisterController {

    private final ClientService clientService;

    public ClientRegisterController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/register")
    public String register() {
        return "clients_register";
    }

    @PostMapping("/register")
    public String register(@Valid ClientRegisterDTO clientRegisterDTO, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (!clientRegisterDTO.getPassword().equals(clientRegisterDTO.getConfirmPassword())) {
            bindingResult.addError(
                    new FieldError("differentConfirmPassword",
                            "confirmPassword",
                            "Password and Confirm password don't match"));
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("clientRegisterDTO", clientRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.clientRegisterDTO",
                    bindingResult);
            return "redirect:register";
        }

        if( !clientService.register(clientRegisterDTO)){
            redirectAttributes.addFlashAttribute("usernameOrEmailExist", true);
            return "redirect:register";
        }



        return "login";
    }

    @ModelAttribute
    public ClientRegisterDTO clientRegisterDTO(){
        return new ClientRegisterDTO();
    }
}

