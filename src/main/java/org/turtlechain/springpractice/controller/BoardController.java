package org.turtlechain.springpractice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.turtlechain.springpractice.dto.BoardDTO;
import org.turtlechain.springpractice.dto.PageRequestDTO;
import org.turtlechain.springpractice.dto.PageResultDTO;
import org.turtlechain.springpractice.entity.Board;
import org.turtlechain.springpractice.service.BoardService;

@RestController
@RequestMapping("/boards")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping()
    public ResponseEntity<PageResultDTO<BoardDTO, Object[]>> getList(PageRequestDTO pageRequestDTO) {
        log.info("list...." + pageRequestDTO);

        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        return ResponseEntity.ok(result);
    }
}
