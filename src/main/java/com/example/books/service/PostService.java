package com.example.books.service;

import com.example.books.dto.PostRequestDTO;
import com.example.books.dto.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostRequestDTO dto);
    List<PostDTO> findAllByUserId(Long userId);
    List<PostDTO> findAll();
    boolean updatePost(PostDTO dto);
    boolean deletePost(Long id);

}
