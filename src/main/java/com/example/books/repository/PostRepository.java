package com.example.books.repository;

import com.example.books.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, PostQuerydslRepository {
    List<Post> findAllById(Long userId);

    boolean findByTitle(String title);

    void deleteByTitle(String title);
}
