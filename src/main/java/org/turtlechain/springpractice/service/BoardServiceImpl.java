package org.turtlechain.springpractice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.turtlechain.springpractice.dto.BoardDTO;
import org.turtlechain.springpractice.dto.PageRequestDTO;
import org.turtlechain.springpractice.dto.PageResultDTO;
import org.turtlechain.springpractice.entity.Board;
import org.turtlechain.springpractice.entity.Member;
import org.turtlechain.springpractice.repository.BoardRepository;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements  BoardService{

    private final BoardRepository repository;

    @Override
    public Long register(BoardDTO dto) {
        log.info(dto);

        Board board = dtoToEntity(dto);

        repository.save(board);

        return board.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
        log.info(pageRequestDTO);

        Function<Object[], BoardDTO> fn = (en -> entityToDTO((Board)en[0], (Member)en[1], (Long)en[2]));

        Page<Object[]> result = repository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("bno").descending()));

        return new PageResultDTO<>(result, fn);

    }

    @Override
    public BoardDTO get(Long bno) {

        Object result = repository.getBoardByBno(bno);

        log.info(result);

        Object[] arr = (Object[])result;

        return entityToDTO((Board)arr[0], (Member)arr[1], (Long)arr[2]);
    }

}
