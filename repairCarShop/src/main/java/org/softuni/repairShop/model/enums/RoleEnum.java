package org.softuni.repairShop.model.enums;

public enum RoleEnum {
    ADMINISTRATOR("Service administrator"),
    MECHANIC_ENGINE("Engine mechanic"),
    MECHANIC_SUSPENSION("Suspension mechanic"),
    MECHANIC_TIRE("Tires mechanic"),
    MECHANIC_BODY("Body painter");

    private final String value;

    RoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
