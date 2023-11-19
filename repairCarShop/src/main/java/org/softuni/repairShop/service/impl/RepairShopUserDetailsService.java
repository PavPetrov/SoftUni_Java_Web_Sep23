package org.softuni.repairShop.service.impl;

import org.softuni.repairShop.model.entity.Client;
import org.softuni.repairShop.model.entity.User;
import org.softuni.repairShop.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class RepairShopUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public RepairShopUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + "not found!"));
    }

    private UserDetails map(User user) {
        return
                org.springframework.security.core.userdetails.User
                        .withUsername(user.getUsername())
                        .password(user.getPassword())
                        .authorities(List.of())  //TODO Add roles
                        .build();
    }

}
