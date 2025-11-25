package com.example.books.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false )
    private String title;

    @Column(name = "content", nullable = false )
    private String content;

    @Column(name = "author", nullable = false )
    private String author;

    @Column(name = "rating", nullable = false )
    private Long rating;

    @Column(name = "created_at", nullable = false )
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
