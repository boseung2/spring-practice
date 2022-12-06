package org.turtlechain.springpractice.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.turtlechain.springpractice.dto.BoardDTO;
import org.turtlechain.springpractice.dto.PageRequestDTO;
import org.turtlechain.springpractice.dto.PageResultDTO;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister() {
        BoardDTO dto = BoardDTO.builder()
                .title("Text...")
                .content("Test...")
                .writerEmail("user55@aaa.com")
                .build();

        Long bno = boardService.register(dto);

    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        result.getDtoList().forEach(System.out::println);

    }

    @Test
    public void testGet() {

        Long bno = 100L;

        BoardDTO boardDTO = boardService.get(bno);

        System.out.println("result: " + boardDTO);

    }


}
