package org.softuni.repairShop.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.softuni.repairShop.model.enums.RepairCategoryEnum;


@Entity
@Table(name = "repair_categories")
public class RepairCategory extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private RepairCategoryEnum repairCategory;

    public RepairCategory() {
    }

    public RepairCategoryEnum getRepairCategory() {
        return repairCategory;
    }

    public RepairCategory setRepairCategory(RepairCategoryEnum repairCategory) {
        this.repairCategory = repairCategory;
        return this;
    }
}
