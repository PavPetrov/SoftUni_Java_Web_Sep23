package org.softuni.pathfinder.repository;

import org.softuni.pathfinder.model.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PicturesRepository extends JpaRepository<Picture, Long> {
}
