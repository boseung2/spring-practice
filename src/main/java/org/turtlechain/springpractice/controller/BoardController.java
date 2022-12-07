package org.turtlechain.springpractice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.turtlechain.springpractice.dto.BoardDTO;
import org.turtlechain.springpractice.dto.PageRequestDTO;
import org.turtlechain.springpractice.dto.PageResultDTO;
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

    @PostMapping()
    public ResponseEntity<Long> register(@RequestBody BoardDTO dto) {
        Long bno = boardService.register(dto);

        return ResponseEntity.ok(bno);
    }

    @GetMapping("/{bno}")
    public ResponseEntity<BoardDTO> get(@PathVariable Long bno) {
        BoardDTO result = boardService.get(bno);

        return ResponseEntity.ok(result);
    }

    @PutMapping()
    public ResponseEntity<Void> modify(@RequestBody BoardDTO requestDTO) {
        boardService.modify(requestDTO);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{bno}")
    public ResponseEntity<Void> remove(@PathVariable Long bno) {
        boardService.removeWithReplies(bno);

        return ResponseEntity.ok().build();
    }
}
