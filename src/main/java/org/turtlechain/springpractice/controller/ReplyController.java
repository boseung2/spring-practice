package org.turtlechain.springpractice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.turtlechain.springpractice.dto.ReplyDTO;
import org.turtlechain.springpractice.service.ReplyService;

import java.util.List;

@RestController
@RequestMapping("/replies")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping("/board/{bno}")
    public ResponseEntity<List<ReplyDTO>> getListByBoard(@PathVariable("bno") Long bno) {

        List<ReplyDTO> result = replyService.getList(bno);

        return ResponseEntity.ok(result);

    }

    @PostMapping()
    public ResponseEntity<Long> register(@RequestBody ReplyDTO replyDTO) {

        Long rno = replyService.register(replyDTO);

        return ResponseEntity.ok(rno);

    }

    @DeleteMapping("/{rno}")
    public ResponseEntity<String> remove(@PathVariable Long rno) {
        replyService.remove(rno);

        return ResponseEntity.ok("success");

    }

    @PutMapping("/{rno}")
    public ResponseEntity<String> modify(@RequestBody ReplyDTO replyDTO) {
        replyService.modify(replyDTO);

        return ResponseEntity.ok("success");
    }

}
