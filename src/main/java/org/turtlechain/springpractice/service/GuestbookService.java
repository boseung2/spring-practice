package org.turtlechain.springpractice.service;

import org.springframework.stereotype.Service;
import org.turtlechain.springpractice.dto.GuestbookDTO;
import org.turtlechain.springpractice.entity.GuestBook;

public interface GuestbookService {
    Long register(GuestbookDTO dto);

    default GuestBook dtoToEntity(GuestbookDTO dto) {
        GuestBook entity = GuestBook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();

        return entity;
    }
}
