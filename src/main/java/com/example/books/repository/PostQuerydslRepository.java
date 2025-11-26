package com.example.books.repository;

import com.example.books.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostQuerydslRepository{
    List<Post> findAllByAuthor(String author);

    Post save(Post post);

    List<Post> findAll();

    Optional<Post> findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);

}
