package org.softuni.pathfinder.repository;

import org.softuni.pathfinder.model.entity.Category;
import org.softuni.pathfinder.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {


    Set<Category> findByNameIn (Set<CategoryEnum> name);
}
