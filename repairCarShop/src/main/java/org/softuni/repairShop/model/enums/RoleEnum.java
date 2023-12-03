package org.softuni.repairShop.model.enums;

public enum RoleEnum {
    ADMINISTRATOR("Service administrator", "ADMINISTRATOR"),
    MECHANIC_ENGINE("Engine mechanic", "ENGINE"),
    MECHANIC_SUSPENSION("Suspension mechanic","SUSPENSION"),
    MECHANIC_TIRE("Tires mechanic", "TIRE"),
    MECHANIC_BODY("Body painter","BODY"),
    CLIENT("Client", "CLIENT");

    private final String value;
    private final String role;

    RoleEnum(String value, String role) {
        this.value = value;
        this.role =role;
    }

    public String getRole() {
        return role;
    }

    public String getValue() {
        return value;
    }

}
