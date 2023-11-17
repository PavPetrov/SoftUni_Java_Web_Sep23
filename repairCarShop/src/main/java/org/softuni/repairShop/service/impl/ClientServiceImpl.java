package org.softuni.repairShop.service.impl;

import org.softuni.repairShop.model.dto.ClientRegisterDTO;
import org.softuni.repairShop.model.entity.Client;
import org.softuni.repairShop.repository.ClientRepository;
import org.softuni.repairShop.service.ClientService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;


    public ClientServiceImpl(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(ClientRegisterDTO clientRegisterDTO) {

        Client client = mapClient(clientRegisterDTO);

        clientRepository.save(client);

    }

    private Client mapClient(ClientRegisterDTO clientRegisterDTO) {
      return  new Client()
              .setUsername(clientRegisterDTO.getUsername())
              .setEmail(clientRegisterDTO.getEmail())
              .setPhoneNumber(clientRegisterDTO.getPhoneNumber())
              .setFullName(clientRegisterDTO.getFullName())
              .setPhoneNumber(clientRegisterDTO.getPhoneNumber())
              .setPassword(passwordEncoder.encode(clientRegisterDTO.getPassword()));
    }

}
