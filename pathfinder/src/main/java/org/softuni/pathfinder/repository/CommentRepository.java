package org.softuni.pathfinder.repository;

import org.softuni.pathfinder.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
