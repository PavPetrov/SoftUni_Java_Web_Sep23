package org.softuni.repairShop.repository;

import org.softuni.repairShop.model.entity.Client;
import org.softuni.repairShop.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
