package org.softuni.repairShop.web;

import jakarta.validation.Valid;
import org.softuni.repairShop.model.dto.VehicleDTO;
import org.softuni.repairShop.model.enums.EngineEnum;
import org.softuni.repairShop.model.enums.VehicleCategoryEnum;
import org.softuni.repairShop.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/clients")
public class ClientPanelController {

    private final VehicleService vehicleService;

    public ClientPanelController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @GetMapping("/add_vehicle")
    public String register() {
        return "add_vehicle";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "client_welcome";
    }

    @GetMapping("/my_tasks")
    public String myTasks() {
        return "my_tasks";
    }


    @PostMapping("/add_vehicle")
    public String adVehicle(@Valid VehicleDTO vehicleDTO,  BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Principal principal) {

        vehicleDTO.setOwner(principal.getName());

        if(bindingResult.hasErrors() ){


            redirectAttributes.addFlashAttribute("vehicleDTO", vehicleDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.vehicleDTO",
                    bindingResult);
            return "redirect:add_vehicle";
        }




        vehicleService.addVehicle(vehicleDTO);

        return "redirect:welcome";
    }

    @ModelAttribute
    public EngineEnum[] engineEnums() {
        return EngineEnum.values();
    }

    @ModelAttribute
    public VehicleCategoryEnum[] vehicleCategoryEnums() {
        return VehicleCategoryEnum.values();
    }
    @ModelAttribute
    public VehicleDTO vehicleDTO(){
        return new VehicleDTO();
    }
}


