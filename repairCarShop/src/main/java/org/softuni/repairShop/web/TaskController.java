package org.softuni.repairShop.web;

import jakarta.validation.Valid;
import org.softuni.repairShop.model.dto.AddTaskDTO;
import org.softuni.repairShop.model.entity.Vehicle;

import org.softuni.repairShop.model.enums.RepairCategoryEnum;
import org.softuni.repairShop.service.ClientService;
import org.softuni.repairShop.service.TaskService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    private final ClientService clientService;

    public TaskController(TaskService taskService, ClientService clientService) {
        this.taskService = taskService;
        this.clientService = clientService;
    }

    @GetMapping("")
    public String tasks() {
        return "tasks";
    }

    @PostMapping("/add")
    public String addTask(@Valid AddTaskDTO addTaskDTO, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetails client) {

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addTaskDTO", addTaskDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addTaskDTO",
                    bindingResult);
            return "redirect:add";
        }
        taskService.addTask(addTaskDTO, client);

        return "redirect:my_tasks";
    }

    @GetMapping("/add")
    public String add(Model model, @AuthenticationPrincipal UserDetails client) {

        List<Vehicle> vehicles = clientService.getVehicles(client.getUsername());

        model.addAttribute("vehicles", vehicles);

        return "add_task";
    }

    @GetMapping("/add/{category}")
    public String add(@PathVariable("category") String category, Model model,
                      @AuthenticationPrincipal UserDetails client) {
        List<Vehicle> vehicles = clientService.getVehicles(client.getUsername());

        model.addAttribute("category", category);
        model.addAttribute("vehicles", vehicles);

        return "add_task";
    }

    @GetMapping("/my_tasks")
    public String myTasks() {
        return "my_tasks";
    }

    @ModelAttribute
    public RepairCategoryEnum[] categoryEnums() {
        return RepairCategoryEnum.values();
    }

    @ModelAttribute
    public AddTaskDTO addTaskDTO() {
        return new AddTaskDTO();
    }
}
