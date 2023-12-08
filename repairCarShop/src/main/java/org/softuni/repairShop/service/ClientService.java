package org.softuni.repairShop.service;

import org.softuni.repairShop.model.dto.ClientRegisterDTO;
import org.softuni.repairShop.model.dto.UserRegisterDTO;
import org.softuni.repairShop.model.dto.VehicleDTO;
import org.softuni.repairShop.model.entity.Client;
import org.softuni.repairShop.model.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    void register(ClientRegisterDTO clientRegisterDTO);

    void clientsInit();

    List<Vehicle> getVehicles(String username);


    Optional<Client> findByUsername(String username);

    Client getByUsername(String username);
}
