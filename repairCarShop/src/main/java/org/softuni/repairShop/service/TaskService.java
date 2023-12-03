package org.softuni.repairShop.service;

import org.softuni.repairShop.model.dto.AddTaskDTO;
import org.softuni.repairShop.model.dto.TaskDTO;
import org.softuni.repairShop.model.entity.Task;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface TaskService {
    void addTask(AddTaskDTO addTaskDTO, UserDetails client);

    List<TaskDTO> getTasks();

    void approve(Long id);
}
