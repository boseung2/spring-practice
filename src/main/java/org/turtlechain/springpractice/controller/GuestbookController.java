package org.turtlechain.springpractice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.turtlechain.springpractice.dto.GuestbookDTO;
import org.turtlechain.springpractice.dto.PageRequestDTO;
import org.turtlechain.springpractice.dto.PageResultDTO;
import org.turtlechain.springpractice.entity.Guestbook;
import org.turtlechain.springpractice.service.GuestbookService;


@RestController
@RequestMapping("/guestbooks")
@Log4j2
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookService service;

    @GetMapping()
    public ResponseEntity<PageResultDTO<GuestbookDTO, Guestbook>> getList(PageRequestDTO pageRequestDTO) {
        PageResultDTO<GuestbookDTO, Guestbook> result = service.getList(pageRequestDTO);

        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Long> register(@RequestBody GuestbookDTO dto) {
        Long gno = service.register(dto);

        return ResponseEntity.ok(gno);
    }

    @GetMapping("/{gno}")
    public ResponseEntity<GuestbookDTO> get(@PathVariable Long gno) {
        GuestbookDTO result = service.read(gno);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{gno}")
    public ResponseEntity<Void> remove(@PathVariable Long gno) {
        service.remove(gno);

        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<Void> modify(@RequestBody GuestbookDTO requestDTO) {
        service.modify(requestDTO);

        return ResponseEntity.ok().build();
    }

}
