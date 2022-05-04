package com.example.guestbook.service;

import com.example.guestbook.dto.GuestbookDTO;
import com.example.guestbook.entity.Guestbook;
import com.example.guestbook.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService{

    private final GuestbookRepository guestbookRepository;

    @Override
    public GuestbookDTO register(GuestbookDTO dto) {

        Guestbook savedBook = guestbookRepository.save(mapToEntity(dto));
        log.info("service_savedBook: {}", savedBook);

        return mapToDto(savedBook);
    }
}
