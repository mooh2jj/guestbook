package com.example.guestbook.repository;

import com.example.guestbook.entity.Guestbook;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.LongStream;

@Slf4j
@DataJpaTest
class GuestbookRepositoryTest {

    @Autowired
    private GuestbookRepository guestbookRepository;

    private Guestbook guestbook;

    @Test
    void create() {
        LongStream.rangeClosed(1,20).forEach(i -> {
            guestbook = Guestbook.builder()
                    .title("book_" + i)
                    .content("book_content_" + i)
                    .writer("book_writer_" + i)
                    .build();
            guestbookRepository.save(guestbook);
        });

        List<Guestbook> guestbooks = guestbookRepository.findAll();
        log.info("guestbooks: {}", guestbooks);

        Assertions.assertThat(guestbooks).isNotNull();
        Assertions.assertThat(guestbooks.size()).isEqualTo(20);
    }
}