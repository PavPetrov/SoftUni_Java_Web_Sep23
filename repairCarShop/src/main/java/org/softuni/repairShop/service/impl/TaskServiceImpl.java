package org.softuni.repairShop.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.repairShop.model.dto.AddTaskDTO;

import org.softuni.repairShop.model.dto.TaskDTO;
import org.softuni.repairShop.model.entity.Client;
import org.softuni.repairShop.model.entity.Task;
import org.softuni.repairShop.repository.ClientRepository;
import org.softuni.repairShop.repository.TaskRepository;
import org.softuni.repairShop.service.TaskService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final ClientRepository clientRepository;
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    public TaskServiceImpl(ClientRepository clientRepository, TaskRepository taskRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addTask(AddTaskDTO addTaskDTO, UserDetails userDetails) {

        Client client = clientRepository.findByUsername(userDetails.getUsername()).orElse(null);

        saveTask(addTaskDTO, client);
    }

    @Override
    public List<TaskDTO> getTasks() {
        List<Task> allTasks = taskRepository.findAll();

        List<TaskDTO> list = allTasks
                .stream()
                .map(task -> modelMapper.map(task, TaskDTO.class))
                .toList();

        return list;
    }

    private void saveTask(AddTaskDTO addTaskDTO, Client client) {

        addTaskDTO.getCategories().forEach(category -> {
            Task task = new Task()
                    .setOwner(client)
                    .setVehicle(addTaskDTO.getAddVehicle())
                    .setRepairCategory(category)
                    .setCreated(LocalDateTime.now())
                    .setCompleted(false)
                    .setApproved(false);
            taskRepository.save(task);
        });

    }
}
