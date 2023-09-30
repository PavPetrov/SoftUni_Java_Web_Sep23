package org.softuni.pathfinder.repository;

import org.softuni.pathfinder.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
