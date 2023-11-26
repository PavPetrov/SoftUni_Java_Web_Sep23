package org.softuni.repairShop.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.repairShop.model.dto.ClientRegisterDTO;
import org.softuni.repairShop.model.entity.Client;
import org.softuni.repairShop.repository.ClientRepository;
import org.softuni.repairShop.service.ClientService;
import org.springframework.stereotype.Service;


@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    private final ModelMapper modelMapper;


    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(ClientRegisterDTO clientRegisterDTO) {

        Client client = modelMapper.map(clientRegisterDTO, Client.class);

        clientRepository.save(client);

    }

    @Override
    public void clientsInit() {

        if(clientRepository.count() == 0){
            ClientRegisterDTO clientRegisterDTO = new ClientRegisterDTO()
                    .setFullName("Client Testov")
                    .setUsername("client")
                    .setEmail("client_test@test.test")
                    .setAddress("Client Address")
                    .setPhoneNumber("089880890808")
                    .setPassword("12345");
           Client client = modelMapper.map(clientRegisterDTO, Client.class);

           clientRepository.save(client);

        }

    }

}
