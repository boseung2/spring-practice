package org.turtlechain.springpractice.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.turtlechain.springpractice.entity.Board;

public interface SearchBoardRepository {

    Board search1();

    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);

}
