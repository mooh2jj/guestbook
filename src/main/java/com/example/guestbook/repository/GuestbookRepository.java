package com.example.guestbook.repository;

import com.example.guestbook.entity.Guestbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long>,
        QuerydslPredicateExecutor<Guestbook> {

//    @Override
//    @Query("select gb from Guestbook gb where gb.id =:id ")
//    Optional<Guestbook> findById(@Param("id") Long id);
}

