package org.softuni.repairShop.repository;

import org.softuni.repairShop.model.entity.Role;
import org.softuni.repairShop.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<Role, Long> {
    List<Role> getAllByuserRoleIn(List<RoleEnum> source);
}
