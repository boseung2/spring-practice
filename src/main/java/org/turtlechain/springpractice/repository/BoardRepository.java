package org.turtlechain.springpractice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.turtlechain.springpractice.entity.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT b, w FROM Board b LEFT JOIN b.writer w WHERE b.bno = :bno")
    Object getBoardWithWriter(@Param("bno") Long bno);

    @Query("SELECT b, r FROM Board b LEFT JOIN Reply r ON r.board = b WHERE b.bno = :bno")
    List<Object[]> getBoardWithReply(@Param("bno") Long bno);

    @Query(value = "SELECT b, w, count(r) "
                    + " FROM Board b "
                    + " LEFT JOIN b.writer w "
                    + " LEFT JOIN Reply r ON r.board = b "
                    + " GROUP BY b",
            countQuery = "SELECT count(b) FROM Board b")
    Page<Object[]> getBoardWithReplyCount(Pageable pageable);

    @Query("SELECT b, w, count(r) "
            + " FROM Board b "
            + " LEFT JOIN b.writer w "
            + " LEFT OUTER JOIN Reply r "
            + " ON r.board = b "
            + " WHERE b.bno = :bno ")
    Object getBoardByBno(@Param("bno") Long bno);

}
