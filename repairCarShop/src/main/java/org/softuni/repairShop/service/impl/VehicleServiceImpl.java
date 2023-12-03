package org.softuni.repairShop.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.repairShop.model.dto.VehicleDTO;
import org.softuni.repairShop.model.entity.Vehicle;
import org.softuni.repairShop.repository.VehicleRepository;
import org.softuni.repairShop.service.VehicleService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    private final ModelMapper modelMapper;



    public VehicleServiceImpl(VehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public void addVehicle(VehicleDTO vehicleDTO) {


        Vehicle vehicle= modelMapper.map(vehicleDTO, Vehicle.class);

        vehicleRepository.save(vehicle);

    }


}
