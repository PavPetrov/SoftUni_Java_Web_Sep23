package org.softuni.repairShop.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.repairShop.model.dto.VehicleDTO;
import org.softuni.repairShop.model.entity.Vehicle;
import org.softuni.repairShop.repository.VehicleRepository;
import org.softuni.repairShop.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void addVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = mapVehicle(vehicleDTO);

        vehicleRepository.save(vehicle);
    }

    private Vehicle mapVehicle(VehicleDTO vehicleDTO) {
        return new Vehicle()
                .setBrand(vehicleDTO.getBrand())
                .setCategory(vehicleDTO.getCategory())
                .setColor(vehicleDTO.getColor())
                .setModel(vehicleDTO.getModel())
                .setYear(vehicleDTO.getYear())
                .setEngine(vehicleDTO.getEngine());
    }
}
