package org.softuni.repairShop.service;

import org.softuni.repairShop.model.dto.ClientRegisterDTO;
import org.softuni.repairShop.model.dto.UserRegisterDTO;
import org.softuni.repairShop.model.dto.VehicleDTO;
import org.softuni.repairShop.model.entity.Vehicle;

import java.util.List;

public interface ClientService {

    void register(ClientRegisterDTO clientRegisterDTO);

    void clientsInit();

    List<Vehicle> getVehicles(String username);

    
}
