package com.example.guestbook.repository;

import com.example.guestbook.entity.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookRepository extends JpaRepository<GuestBook, Long> {

}
