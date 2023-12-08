package org.softuni.repairShop.service;

import org.softuni.repairShop.model.dto.AddTaskDTO;
import org.softuni.repairShop.model.dto.TaskDTO;
import org.softuni.repairShop.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface TaskService {
    void addTask(AddTaskDTO addTaskDTO, UserDetails client);

    List<TaskDTO> getTasks();

    void approve(Long id);

    void complete(Long id, User user);

    String findByIdGetOwnerUsername(Long id);

    void deleteTask(Long id);
}
