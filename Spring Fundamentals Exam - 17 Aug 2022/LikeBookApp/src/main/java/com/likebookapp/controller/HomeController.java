package com.likebookapp.controller;

import com.likebookapp.model.Dto.UserRegistrationDTO;
import com.likebookapp.model.entity.MoodEnum;
import com.likebookapp.model.viewModel.UserPostViewModel;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.service.PostService;
import com.likebookapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {
    private final CurrentUser currentUser;

    private final PostService postService;


    public HomeController(CurrentUser currentUser, PostRepository postRepository, PostService postService) {
        this.currentUser = currentUser;
        this.postService = postService;
    }

    @GetMapping("home")
    public String index(Model model) {
        boolean isLogged = currentUser.isLogged();
        Long userId = currentUser.getId();

        List<UserPostViewModel> userPosts = postService.findAllByUserId(userId);

        model.addAttribute("userPosts", userPosts);

        return isLogged ? "home" : "redirect:/";
    }



    @GetMapping("/")
    public String index() {
        boolean isLogged = currentUser.isLogged();
        return isLogged ? "redirect:/home" : "index";
    }

}


