package com.example.books.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

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

    @Column(name = "createdAt", nullable = false )
    private LocalDateTime createdAt;
}
