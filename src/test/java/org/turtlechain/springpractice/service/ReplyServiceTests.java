package org.turtlechain.springpractice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.turtlechain.springpractice.dto.ReplyDTO;

import java.util.List;

@SpringBootTest
public class ReplyServiceTests {

    @Autowired
    private ReplyService service;

    @Test
    public void testGetList() {

        Long bno = 100L;

        List<ReplyDTO> replyDTOLIst = service.getList(bno);

        replyDTOLIst.forEach(System.out::print);

    }

}
