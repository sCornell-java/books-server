package com.example.books.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private Long rating;
    private LocalDateTime createdAt;
}
