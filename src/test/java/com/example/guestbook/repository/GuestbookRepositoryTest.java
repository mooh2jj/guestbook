package com.example.guestbook.repository;

import com.example.guestbook.entity.Guestbook;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
class GuestbookRepositoryTest {

    @Autowired
    private GuestbookRepository guestbookRepository;
    private Guestbook guestbook;

    @BeforeEach
    void setup() {
        guestbook = Guestbook.builder()
                .title("123L_title")
                .content("123L_content")
                .writer("123L_writer")
                .build();
    }

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

        assertThat(guestbooks).isNotNull();
        assertThat(guestbooks.size()).isEqualTo(20);
    }

    @Test
    public void findById(){

        Guestbook savedbook = guestbookRepository.save(guestbook);

        Guestbook findGuestbook = guestbookRepository.findById(savedbook.getId()).get();
        findGuestbook.changeTitle("new_title");
        findGuestbook.changeContent("new_content");

        log.info("findGuestbook : {}",findGuestbook);

        assertThat(findGuestbook.getTitle()).isEqualTo("new_title");
        assertThat(findGuestbook.getContent()).isEqualTo("new_content");
    }
}