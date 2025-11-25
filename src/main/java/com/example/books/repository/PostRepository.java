package com.example.books.repository;

import com.example.books.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>, PostQuerydslRepository {
}
