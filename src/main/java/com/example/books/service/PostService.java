package com.example.books.service;

import com.example.books.dto.PostRequestDTO;
import com.example.books.dto.PostDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostRequestDTO dto);
    List<PostDTO> findAllByAuthor(@RequestParam(value = "author") String author);
    List<PostDTO> findAll();
    boolean updatePost(PostDTO dto);
    boolean deletePost(Long id);
}
