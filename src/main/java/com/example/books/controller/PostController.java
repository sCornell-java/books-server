package com.example.books.controller;

import com.example.books.entity.Post;
import com.example.books.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping
    public Map save(@RequestBody Post post) {
        Post savedPost = postRepository.save(post);
        return savedPost == null
                ? Map.of("res", "fail", "msg", "등록 실패!")
                : Map.of("res", "success", "data", savedPost);
    }

    @GetMapping
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}

