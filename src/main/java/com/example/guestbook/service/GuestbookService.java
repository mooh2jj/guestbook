package com.example.guestbook.service;

import com.example.guestbook.dto.GuestbookDTO;
import com.example.guestbook.entity.Guestbook;

public interface GuestbookService {

    GuestbookDTO register(GuestbookDTO dto);

    default Guestbook mapToEntity(GuestbookDTO dto) {
        return Guestbook.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
    }

    default GuestbookDTO mapToDto(Guestbook entity) {
        return GuestbookDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .build();
    }

}
