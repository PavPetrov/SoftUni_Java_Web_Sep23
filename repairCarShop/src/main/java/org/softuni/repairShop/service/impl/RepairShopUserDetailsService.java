package org.softuni.repairShop.service.impl;

import org.softuni.repairShop.model.entity.Client;
import org.softuni.repairShop.model.entity.Role;
import org.softuni.repairShop.model.entity.User;
import org.softuni.repairShop.repository.ClientRepository;
import org.softuni.repairShop.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public class RepairShopUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    public RepairShopUserDetailsService(UserRepository userRepository, ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository
                .findByUsername(username);

        Optional<Client> client = clientRepository
                .findByUsername(username);

        if(user.isPresent()){
            return user
                    .map(this::map)
                    .orElseThrow(() -> new UsernameNotFoundException("User " + username + "not found!"));
        }

        if(client.isPresent()){
            return client
                    .map(this::map)
                    .orElseThrow(() -> new UsernameNotFoundException("User " + username + "not found!"));
        }

        throw new UsernameNotFoundException("User " + username + "not found!");

    }


    private UserDetails map(User user) {
        return
                org.springframework.security.core.userdetails.User
                        .withUsername(user.getUsername())
                        .password(user.getPassword())
         //               .authorities(mapRole(user.getUserRole().getValue())
                    //    .authorities(List.of())  //TODO Add roles
                        .build();
    }

    private UserDetails map(Client client) {
        return
                org.springframework.security.core.userdetails.User
                        .withUsername(client.getUsername())
                        .password(client.getPassword())
                   //     .authorities(mapRole(client.getRole()))  //TODO Add roles
                        .build();
    }

    private static GrantedAuthority mapRole(Role role){
        return new SimpleGrantedAuthority("ROLE_" + role.getUserRole().name());
    }

}
