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
        //TODO Filter completed
        List<TaskDTO> tasks = taskService.getTasks();

        return tasks;
    }

    @GetMapping("/tasks/users")
    @ResponseBody
    public List<TaskDTO> tasksUsers(@AuthenticationPrincipal UserDetails userDetails) {

        if (userDetails != null) {
           /* String username = userDetails.getUsername();

            User user = userService.findByUsername(username);

            List<String> userRoles =
                    user.getRoles().stream().map(role -> role.getUserRole().getRole())
                            .toList();*/
            List<String> userRoles = userDetails.getAuthorities()
                    .stream().map(u ->u.getAuthority().replace("ROLE_MECHANIC_","")).toList();

            List<TaskDTO> allApprovedTasks = taskService.getTasks()
                    .stream().filter(TaskDTO::getApproved).toList();

            List<TaskDTO> userTasks = allApprovedTasks.stream().filter(task ->
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

    @PatchMapping("/tasks/complete/{id}")
    public String complete(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            String username = userDetails.getUsername();

            User user = userService.findByUsername(username);
            taskService.complete(id, user);
        }
    //    taskService.complete(id, null);
        return "tasks";
    }

}
