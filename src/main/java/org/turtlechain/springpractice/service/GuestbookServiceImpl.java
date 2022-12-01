package org.turtlechain.springpractice.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.turtlechain.springpractice.dto.GuestbookDTO;
import org.turtlechain.springpractice.entity.GuestBook;

@Service
@Log4j2
public class GuestbookServiceImpl implements GuestbookService{

    @Override
    public Long register(GuestbookDTO dto) {

        log.info("DTO--------");
        log.info(dto);

        GuestBook entity = dtoToEntity(dto);

        log.info(entity);

        return null;
    }
}
