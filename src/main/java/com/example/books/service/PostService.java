package com.example.books.service;

import com.example.books.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService extends JpaRepository<Post,Long> {
public interface PostService {
}
