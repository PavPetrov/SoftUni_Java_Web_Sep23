package org.softuni.repairShop.service.impl;

import org.softuni.repairShop.model.entity.RepairCategory;
import org.softuni.repairShop.model.entity.Role;
import org.softuni.repairShop.model.enums.RepairCategoryEnum;
import org.softuni.repairShop.model.enums.RoleEnum;
import org.softuni.repairShop.repository.RepairCategoryRepository;
import org.softuni.repairShop.repository.UserRoleRepository;
import org.softuni.repairShop.service.RepairCategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RepairCategoryServiceImpl implements RepairCategoryService {

    private final RepairCategoryRepository repairCategoryRepository;

    public RepairCategoryServiceImpl(
            RepairCategoryRepository repairCategoryRepository) {
        this.repairCategoryRepository = repairCategoryRepository;
    }

    @Override
    public void repairCategoryInit() {

        if (repairCategoryRepository.count() == 0) {
            Arrays.stream(RepairCategoryEnum.values()).forEach(category -> {
                RepairCategory repairCategory = new RepairCategory();
                repairCategory.setRepairCategory(category);
                repairCategoryRepository.save(repairCategory);
            });
        }

    }
}
