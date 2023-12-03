package org.softuni.repairShop.web;

import org.softuni.repairShop.model.dto.AddTaskDTO;
import org.softuni.repairShop.model.entity.Vehicle;

import org.softuni.repairShop.model.enums.RepairCategoryEnum;
import org.softuni.repairShop.service.ClientService;
import org.softuni.repairShop.service.TaskService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String addTasks(AddTaskDTO addTaskDTO, @AuthenticationPrincipal UserDetails client) {

        taskService.addTask(addTaskDTO, client);

        return "redirect:/tasks";
    }


    @GetMapping("/add/{category}")
    public String add(@PathVariable("category") String category, Model model,
                      @AuthenticationPrincipal UserDetails client) {
        List<Vehicle> vehicles = clientService.getVehicles(client.getUsername());

        model.addAttribute("category", category);
        model.addAttribute("vehicles", vehicles);

        return "add_task";
    }

    @ModelAttribute
    public RepairCategoryEnum[] categoryEnums() {
        return RepairCategoryEnum.values();
    }

    @ModelAttribute
    public AddTaskDTO addTaskDTO(){
        return  new AddTaskDTO();
    }
}
