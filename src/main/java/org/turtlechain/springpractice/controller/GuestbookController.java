package org.turtlechain.springpractice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
        return new ResponseEntity<>(service.getList(pageRequestDTO), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> register(@RequestBody GuestbookDTO dto) {
        log.info("dto..." + dto);

        Long gno = service.register(dto);

        return new ResponseEntity<>(gno, HttpStatus.OK);
    }

}
