package com.likebookapp.controller;

import com.likebookapp.model.Dto.PostAddDTO;
import com.likebookapp.model.entity.MoodEnum;
import com.likebookapp.service.PostService;
import com.likebookapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final CurrentUser currentUser;

    private final PostService postService;

    public PostController(CurrentUser currentUser, PostService postService) {
        this.currentUser = currentUser;
        this.postService = postService;
    }

    public CurrentUser getCurrentUser() {
        return currentUser;
    }

    @GetMapping("add")
    public String add() {

        return currentUser.isLogged() ? "post-add" : "redirect:/";
    }

    @PostMapping("add")
    public String add(@Valid PostAddDTO postAddDTO, BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("postAddDTO", postAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.postAddDTO",
                    bindingResult);
            return "redirect:add";
        }

        postService.addPost(postAddDTO);


        return currentUser.isLogged() ? "redirect:/home" : "redirect:/";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable Long id) {

        postService.removePost(id);

        return "redirect:/";
    }

    @GetMapping("like/{id}")
    public String like(@PathVariable Long id) {

        postService.likePost(id);

        return "redirect:/";
    }

    @ModelAttribute()
    public MoodEnum[] mood() {
        return MoodEnum.values();
    }

    @ModelAttribute()
    public PostAddDTO postAddDTO() {
        return new PostAddDTO();
    }


}
