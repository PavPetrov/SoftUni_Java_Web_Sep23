package org.softuni.repairShop.web;

import org.softuni.repairShop.model.dto.TaskDTO;
import org.softuni.repairShop.model.dto.UserEditDTO;
import org.softuni.repairShop.model.entity.Client;
import org.softuni.repairShop.model.entity.User;

import org.softuni.repairShop.service.ClientService;
import org.softuni.repairShop.service.TaskService;
import org.softuni.repairShop.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {


    private final TaskService taskService;
    private final UserService userService;
    private final ClientService clientService;

    public RestController(TaskService taskService, UserService userService, ClientService clientService) {
        this.taskService = taskService;

        this.userService = userService;

        this.clientService = clientService;
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

            List<String> userRoles = userDetails.getAuthorities()
                    .stream().map(u -> u.getAuthority().replace("ROLE_MECHANIC_", "")).toList();

            List<TaskDTO> allApprovedTasks = taskService.getTasks()
                    .stream().filter(TaskDTO::getApproved).toList();

            List<TaskDTO> userTasks = allApprovedTasks.stream().filter(task ->
                    userRoles.contains(task.getRepairCategory().name())).toList();

            return userTasks;
        }

        return null;
    }

    @GetMapping("/tasks/clients")
    @ResponseBody
    public List<TaskDTO> tasksClients(@AuthenticationPrincipal UserDetails userDetails) {

        if (userDetails != null) {

            String username = userDetails.getUsername();
            Optional<Client> client = clientService.findByUsername(username);
            if (client.isPresent()) {
                Long clientId = client.get().getId();
                List<TaskDTO> list = taskService.getTasks()
                        .stream().filter(taskDTO -> taskDTO.getOwnerId().equals(clientId)).toList();

                return list;
            }
        }
        return null;
    }


    @DeleteMapping("/tasks/clients/{id}")
    public void delClientTask(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {

        String clientUsername = userDetails.getUsername();

        String taskUsernameById = taskService.findByIdGetOwnerUsername(id);

        if (clientUsername.equals(taskUsernameById)) {

            taskService.deleteTask(id);
        }
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
        return "tasks";
    }


    @PatchMapping("/user/activate/{id}/{ctx}")
    public String activate(@PathVariable Long id, @PathVariable Boolean ctx) {

        userService.proceedActive( id,  ctx);

        return "activate";
    }
}
