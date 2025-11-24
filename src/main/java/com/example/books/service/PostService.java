package com.example.books.service;

import com.example.books.DTO.PostRequestDto;
import com.example.books.dto.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostRequestDto dto);
    List<PostDTO> findAllByUserId(Long userId);
    List<PostDTO> findAll();
    boolean deletePost(Long id);
}
