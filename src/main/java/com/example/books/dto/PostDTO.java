package com.example.books.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String author;
    private String content;
    private Long rating;
    private LocalDateTime createdAt;
}
