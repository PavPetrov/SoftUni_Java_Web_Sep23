package org.softuni.repairShop.web;

import org.softuni.repairShop.model.dto.TaskDTO;
import org.softuni.repairShop.model.entity.Role;
import org.softuni.repairShop.model.entity.User;
import org.softuni.repairShop.model.enums.RoleEnum;
import org.softuni.repairShop.service.TaskService;
import org.softuni.repairShop.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final TaskService taskService;
    private final UserService userService;

    public RestController(TaskService taskService, UserService userService) {
        this.taskService = taskService;

        this.userService = userService;
    }

    @GetMapping("/tasks")
    @ResponseBody
    public List<TaskDTO> tasks() {

        List<TaskDTO> tasks = taskService.getTasks();

        return tasks;
    }

    @GetMapping("/tasks/users")
    @ResponseBody
    public List<TaskDTO> tasksUsers(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            String username = userDetails.getUsername();

            User user = userService.findByUsername(username);

            List<String> userRoles =
                    user.getRoles().stream().map(role -> role.getUserRole().getRole())
                            .toList();

            List<TaskDTO> allTasks = taskService.getTasks();

         //TODO FILTER only approved & match USER CATEGORY ROLE
            //      TIRES, SUSPENSION, ENGINE, BODY

            //      MECHANIC_ENGINE("Engine mechanic"), MECHANIC_SUSPENSION("Suspension mechanic"),
            //      MECHANIC_TIRE("Tires mechanic"), MECHANIC_BODY
            //           tasks.stream().filter(t ->t.getRepairCategory())

            List<TaskDTO> userTasks = allTasks.stream().filter(task ->
                    userRoles.contains(task.getRepairCategory().name())).toList();

            return userTasks;
        }

        return null;
    }

    @PatchMapping("/tasks/approve/{id}")
    public String approve(@PathVariable Long id) {

        taskService.approve(id);

        return "tasks";
    }


}
