package org.softuni.repairShop.web;

import org.softuni.repairShop.model.dto.AddTaskDTO;
import org.softuni.repairShop.model.dto.TaskDTO;
import org.softuni.repairShop.model.entity.Client;
import org.softuni.repairShop.model.entity.Task;
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

@RestController
@RequestMapping("/tasks/api")
public class TaskRestController {

    private final TaskService taskService;

    private final ClientService clientService;

    public TaskRestController(TaskService taskService, ClientService clientService) {
        this.taskService = taskService;
        this.clientService = clientService;
    }

    @GetMapping("")
    @ResponseBody
    public List<TaskDTO> tasks() {

        List<TaskDTO> tasks = taskService.getTasks();

        return tasks;
    }





}
