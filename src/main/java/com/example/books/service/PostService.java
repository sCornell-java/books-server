package com.example.books.service;

import com.example.books.entity.Post;
import java.util.List;

public interface PostService {
    Post createPost(Post post);
    List<Post> findAllByUserId(Long userId);
}