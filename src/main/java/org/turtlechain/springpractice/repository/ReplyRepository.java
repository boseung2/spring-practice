package org.turtlechain.springpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.turtlechain.springpractice.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
