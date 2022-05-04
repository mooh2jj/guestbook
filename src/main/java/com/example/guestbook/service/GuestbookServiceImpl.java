package com.example.guestbook.service;

import com.example.guestbook.dto.GuestbookDTO;
import com.example.guestbook.dto.PageResponse;
import com.example.guestbook.entity.Guestbook;
import com.example.guestbook.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public PageResponse list(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<GuestbookDTO> guestbookPage = guestbookRepository.findAll(pageable).map(this::mapToDto);

        return PageResponse.builder()
                .content(guestbookPage.getContent())
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalElements(guestbookPage.getTotalElements())
                .totalPages(guestbookPage.getTotalPages())
                .last(guestbookPage.isLast())
                .build();

    }

}
