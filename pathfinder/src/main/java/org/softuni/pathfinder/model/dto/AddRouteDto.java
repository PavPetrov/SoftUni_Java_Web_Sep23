package org.softuni.pathfinder.model.dto;


import org.softuni.pathfinder.model.enums.CategoryEnum;
import org.softuni.pathfinder.model.enums.RouteLevel;


import java.util.Set;

public record AddRouteDto(
        String name,
        String description,
        String gpxCoordinates,
        RouteLevel level,
        String videoUrl,
        Set<CategoryEnum> categories,
        String author
) {
}
