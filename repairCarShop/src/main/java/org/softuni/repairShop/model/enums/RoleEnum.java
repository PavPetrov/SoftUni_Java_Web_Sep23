package org.softuni.repairShop.model.enums;

public enum RoleEnum {
    ADMINISTRATOR("Admin"),
    MECHANIC_ENGINE("Engine"),
    MECHANIC_SUSPENSION("Suspension"),
    MECHANIC_TIRE("Tires"),
    MECHANIC_BODY("Body");

    private String value;

    RoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
