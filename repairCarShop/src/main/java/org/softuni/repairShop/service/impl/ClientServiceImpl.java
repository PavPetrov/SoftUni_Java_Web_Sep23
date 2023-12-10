package org.softuni.repairShop.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.repairShop.model.dto.ClientRegisterDTO;
import org.softuni.repairShop.model.entity.Client;
import org.softuni.repairShop.model.entity.Vehicle;
import org.softuni.repairShop.repository.ClientRepository;
import org.softuni.repairShop.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    private final ModelMapper modelMapper;


    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(ClientRegisterDTO clientRegisterDTO) {

        Client client = modelMapper.map(clientRegisterDTO, Client.class);

        if( clientRepository.findByUsername(client.getUsername()).isPresent()
        || clientRepository.findByEmail(client.getEmail()).isPresent()){
            return false;
        }


        clientRepository.save(client);

        return true;
    }

    @Override
    public void clientsInit() {

        if (clientRepository.count() == 0) {
            ClientRegisterDTO clientRegisterDTO = new ClientRegisterDTO()
                    .setFullName("Client Testov")
                    .setUsername("client")
                    .setEmail("client_test@test.test")
                    .setAddress("Client Address")
                    .setPhoneNumber("089880890808")
                    .setPassword("12345");
            Client client = modelMapper.map(clientRegisterDTO, Client.class);

            clientRepository.save(client);

            ClientRegisterDTO client1RegisterDTO1 = new ClientRegisterDTO()
                    .setFullName("Client Testov 1")
                    .setUsername("client1")
                    .setEmail("client1_test@test.test")
                    .setAddress("Client Address")
                    .setPhoneNumber("089880890808")
                    .setPassword("12345");
            Client client1 = modelMapper.map(client1RegisterDTO1, Client.class);

            clientRepository.save(client1);

            ClientRegisterDTO clientRegisterDTO2 = new ClientRegisterDTO()
                    .setFullName("Client Testov 2")
                    .setUsername("client2")
                    .setEmail("client2_test@test.test")
                    .setAddress("Client Address2")
                    .setPhoneNumber("089880890808")
                    .setPassword("12345");
            Client client2 = modelMapper.map(clientRegisterDTO2, Client.class);

            clientRepository.save(client2);

            ClientRegisterDTO clientRegisterDTO3 = new ClientRegisterDTO()
                    .setFullName("Client Testov3")
                    .setUsername("client3")
                    .setEmail("client3_test@test.test")
                    .setAddress("Client Address3")
                    .setPhoneNumber("089880890808")
                    .setPassword("12345");
            Client client3 = modelMapper.map(clientRegisterDTO3, Client.class);

            clientRepository.save(client3);

        }
    }

    @Override
    public List<Vehicle> getVehicles(String username) {

        Optional<Client> client = clientRepository.findByUsername(username);

        return client.map(Client::getVehicles).orElse(null);
    }

    @Override
    public Optional<Client> findByUsername(String username) {
        return clientRepository.findByUsername(username);
    }

    @Override
    public Client getByUsername(String username) {
        return clientRepository.getByUsername(username);
    }

}
