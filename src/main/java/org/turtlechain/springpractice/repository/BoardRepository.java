package org.turtlechain.springpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.turtlechain.springpractice.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
