package org.softuni.repairShop.repository;

import org.softuni.repairShop.model.entity.Client;
import org.softuni.repairShop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
