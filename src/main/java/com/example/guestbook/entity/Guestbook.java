package com.example.guestbook.entity;

import com.example.guestbook.dto.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"gno", "title", "content", "writer"})
public class Guestbook extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1500, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    @Builder
    public Guestbook(Long gno, String title, String content, String writer) {
        this.gno = gno;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
