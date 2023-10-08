package org.softuni.pathfinder.service.impl;

import org.softuni.pathfinder.model.dto.AddRouteDto;
import org.softuni.pathfinder.model.entity.Category;
import org.softuni.pathfinder.model.entity.Route;
import org.softuni.pathfinder.repository.CategoryRepository;
import org.softuni.pathfinder.repository.RouteRepository;
import org.softuni.pathfinder.repository.UserRepository;
import org.softuni.pathfinder.service.RoutesService;
import org.softuni.pathfinder.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoutesServiceImpl implements RoutesService {

    private final RouteRepository routeRepository;

    private final CategoryRepository categoryRepository;

    private final LoggedUser loggedUser;

    private final UserRepository userRepository;

    public RoutesServiceImpl(RouteRepository routeRepository,
                             CategoryRepository categoryRepository,
                             LoggedUser loggedUser, UserRepository userRepository) {
        this.routeRepository = routeRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    @Override
    public void addRoute(AddRouteDto addRouteDto) {

        routeRepository.save(map(addRouteDto));

    }

    //TODO  better implement mapping Dto to Entity -> refactor ModelAndView? ModelMapper? ......
    private Route map(AddRouteDto addRouteDto) {
        Route route = new Route();

        route.setName(addRouteDto.name());

        route.setDescription(addRouteDto.description());
        route.setLevel(addRouteDto.level());
        route.setGpxCoordinates(addRouteDto.gpxCoordinates());
        route.setVideoUrl(addRouteDto.videoUrl());
        route.setAuthor(userRepository.findByUsername(loggedUser.getUsername()));

        Set<Category> categories = categoryRepository.findByNameIn(addRouteDto.categories());

        route.setCategories(categories);

        return route;
    }
}
