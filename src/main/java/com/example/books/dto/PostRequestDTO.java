package com.example.books.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PostRequestDTO {
    private String title;
    private String content;
    private String author;
    private Long rating;
}
