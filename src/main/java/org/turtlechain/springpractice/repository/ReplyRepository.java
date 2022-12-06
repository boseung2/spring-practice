package org.turtlechain.springpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.turtlechain.springpractice.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Modifying
    @Query("DELETE FROM Reply r where r.board.bno = :bno")
    void deleteByBno(Long bno);

}
