package com.example.books.service;

import com.example.books.DTO.PostRequestDto;
import com.example.books.DTO.PostResponseDto;

import java.util.List;

public interface PostService {
    PostResponseDto createPost(PostRequestDto dto);
    List<PostResponseDto> findAllByUserId(Long userId);
    List<PostResponseDto> findAll();
}
