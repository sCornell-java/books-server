package com.example.books.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PostRequestDto {
    private String title;
    private String content;
    private String author;
    private Long rating;
}
