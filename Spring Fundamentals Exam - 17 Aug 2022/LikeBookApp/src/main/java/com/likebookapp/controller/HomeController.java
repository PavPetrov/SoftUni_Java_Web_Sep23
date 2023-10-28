package com.likebookapp.controller;

import com.likebookapp.model.viewModel.HomeViewModel;
import com.likebookapp.model.viewModel.UserPost;
import com.likebookapp.service.PostService;
import com.likebookapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final CurrentUser currentUser;

    private final PostService postService;


    public HomeController(CurrentUser currentUser, PostService postService) {
        this.currentUser = currentUser;
        this.postService = postService;
    }

    @GetMapping("home")
    public String index(Model model) {
        boolean isLogged = currentUser.isLogged();
        Long userId = currentUser.getId();

        HomeViewModel allPosts = postService.getAllPosts();

//        List<UserPost> userPosts = postService.findAllByUserId(userId);
//
//        model.addAttribute("userPosts", userPosts);

        model.addAttribute("userPosts", allPosts.getUserPosts());
        model.addAttribute("allOtherPosts", allPosts.getAllOtherPosts());


        return isLogged ? "home" : "redirect:/";
    }



    @GetMapping("/")
    public String index() {
        boolean isLogged = currentUser.isLogged();
        return isLogged ? "redirect:/home" : "index";
    }

}


