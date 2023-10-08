package org.softuni.pathfinder.web;

import org.softuni.pathfinder.model.dto.AddRouteDto;
import org.softuni.pathfinder.service.RoutesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RoutesController {

    private final RoutesService routesService;

    public RoutesController(RoutesService routesService) {
        this.routesService = routesService;
    }


    @GetMapping("/routes/add")
    public String addRoute() {
        return "add-route";
    }


    @PostMapping("/routes/add")
    public String addRoute(AddRouteDto addRouteDto) {

        routesService.addRoute(addRouteDto);

        return "index";
    }

    @GetMapping("/routes")
    public String routs(String name) {
        return "routes";
    }

}
