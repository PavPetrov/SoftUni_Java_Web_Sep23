package org.softuni.repairShop.repository;

import org.softuni.repairShop.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findAllByOwnerUsername(String username);
}
