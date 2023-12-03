package org.softuni.repairShop.model.dto;
import org.softuni.repairShop.model.entity.RepairCategory;
import org.softuni.repairShop.model.entity.Vehicle;
import org.softuni.repairShop.model.enums.RepairCategoryEnum;


import java.util.List;

public class AddTaskDTO {

private Vehicle addVehicle;

private List<RepairCategoryEnum> categories;

    public AddTaskDTO() {
    }

    public Vehicle getAddVehicle() {
        return addVehicle;
    }

    public AddTaskDTO setAddVehicle(Vehicle addVehicle) {
        this.addVehicle = addVehicle;
        return this;
    }

    public List<RepairCategoryEnum> getCategories() {
        return categories;
    }

    public AddTaskDTO setCategories(List<RepairCategoryEnum> categories) {
        this.categories = categories;
        return this;
    }
}
