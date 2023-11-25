package org.softuni.repairShop.service;

import org.softuni.repairShop.model.dto.ClientRegisterDTO;
import org.softuni.repairShop.model.dto.UserRegisterDTO;
import org.softuni.repairShop.model.dto.VehicleDTO;

public interface ClientService {

    void register(ClientRegisterDTO clientRegisterDTO);

    void clientsInit();
}
