package com.example.guestbook.service;

import com.example.guestbook.dto.GuestbookDTO;
import com.example.guestbook.entity.Guestbook;
import com.example.guestbook.repository.GuestbookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
class GuestbookServiceTest {

    @Mock
    private GuestbookRepository guestbookRepository;

    @InjectMocks
    private GuestbookServiceImpl guestbookService;

    private Guestbook guestbook;

    @BeforeEach
    void setup() {
        guestbook = Guestbook.builder()
                .id(123L)
                .title("123L_title")
                .content("123L_content")
                .writer("123L_writer")
                .build();
    }

    @Test
    void register(){
        // given
        when(guestbookRepository.save(any(Guestbook.class)))
                .then(AdditionalAnswers.returnsFirstArg());
        GuestbookDTO dto = GuestbookDTO.builder()
                .id(guestbook.getId())
                .title(guestbook.getTitle())
                .content(guestbook.getContent())
                .writer(guestbook.getWriter())
                .build();
        // when
        GuestbookDTO guestbookDTO = guestbookService.register(dto);
        log.info("guestbookDTO: {}", guestbookDTO);
        // then
        assertThat(guestbookDTO).isNotNull();

    }

}