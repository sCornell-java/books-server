package com.example.books.repository;

import com.example.books.entity.Post;

import java.util.List;

public interface PostQuerydslRepository {
    List<Post> findAllByAuthor(String author);
}
