package org.softuni.repairShop.service;

import org.softuni.repairShop.model.dto.VehicleDTO;
import org.softuni.repairShop.model.entity.Vehicle;

import java.util.List;


public interface VehicleService {
    void addVehicle(VehicleDTO vehicleDTO);

    List<VehicleDTO> findByOwnerUsername(String username);

    Vehicle findById(Long vehicleId);

    void deleteVehicle(Vehicle vehicle);

    void save(Vehicle vehicle);
}
