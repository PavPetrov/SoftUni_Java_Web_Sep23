package com.likebookapp.controller;

import com.likebookapp.model.Dto.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("register")
    public String register() {
        return "register";


    }

    //  @PostMapping("/add")
//  public String add(
//      @Valid CreateOfferDTO createOfferDTO,
//      BindingResult bindingResult,
//      RedirectAttributes rAtt) {
//
//    if(bindingResult.hasErrors()){
//      rAtt.addFlashAttribute("createOfferDTO", createOfferDTO);
//      rAtt.addFlashAttribute("org.springframework.validation.BindingResult.createOfferDTO", bindingResult);
//      return "redirect:/offer/add";
//    }
    @PostMapping("register")
    public String register(@Valid UserRegistrationDTO userRegistrationDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors() ||
        !userRegistrationDTO.password.equals(userRegistrationDTO.confirmPassword)){
            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO",
                    bindingResult);

            //TODO Send message password if confirmPassword didnt match
            return "redirect:register";
        }


        return "login";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @ModelAttribute
    public UserRegistrationDTO userRegistrationDTO() {
        return new UserRegistrationDTO();
    }

}
