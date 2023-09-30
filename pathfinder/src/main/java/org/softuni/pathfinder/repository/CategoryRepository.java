package org.softuni.pathfinder.repository;

import org.softuni.pathfinder.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
