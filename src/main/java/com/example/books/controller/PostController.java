package com.example.books.controller;

import com.example.books.dto.ResponseDTO;
import com.example.books.entity.Post;
import com.example.books.repository.PostRepository;
import com.example.books.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

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

    @DeleteMapping("/{id}")
    public ResponseDTO deletePost(
            @PathVariable("id") Long id
    ) {
        boolean result = postService.deletePost(id);
        return new ResponseDTO(result ? "deleted" : "not found");
    }
}

