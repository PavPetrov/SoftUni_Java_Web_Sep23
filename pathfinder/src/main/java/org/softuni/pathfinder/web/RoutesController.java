package org.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoutesController {

    @GetMapping("/routes/add")
    public String addRoute() {
        return "add-route";
    }


    @PostMapping("/routes/add")
    public String addRoute(String name) {
        return "index";
    }

    @GetMapping("/routes")
    public String routs(String name) {
        return "routes";
    }

}
