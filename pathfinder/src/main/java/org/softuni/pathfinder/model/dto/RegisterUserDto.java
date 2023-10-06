package org.softuni.pathfinder.model.dto;

public record RegisterUserDto(
        String username,
        String fullName,
        String email,
        int age,
        String password,
        String confirmPassword) {
}
