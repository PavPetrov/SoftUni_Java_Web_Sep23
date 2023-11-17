package org.softuni.repairShop.web;

import org.softuni.repairShop.model.dto.VehicleDTO;
import org.softuni.repairShop.model.enums.EngineEnum;
import org.softuni.repairShop.model.enums.VehicleCategoryEnum;
import org.softuni.repairShop.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients")
public class ClientPanelController {

    private final VehicleService vehicleService;

    public ClientPanelController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @GetMapping("/add_vehicle")
    public String register(){
        return "add_vehicle";
    }

    @PostMapping("/add_vehicle")
    public String register(VehicleDTO vehicleDTO){

        vehicleService.addVehicle(vehicleDTO);

        return "index";
    }

    @ModelAttribute
    public EngineEnum[] engineEnums(){
        return EngineEnum.values();
    }

    @ModelAttribute
    public VehicleCategoryEnum[] vehicleCategoryEnums(){
        return VehicleCategoryEnum.values();
    }
}

