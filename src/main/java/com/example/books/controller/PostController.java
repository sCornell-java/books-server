package com.example.books.controller;

import com.example.books.dto.PostDTO;
import com.example.books.dto.PostRequestDTO;
import com.example.books.dto.ResponseDTO;
import com.example.books.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostServiceImpl postService;


    @PostMapping
    public ResponseDTO save(@RequestBody PostRequestDTO post) {
        PostDTO savedPost = postService.createPost(post);
        return new ResponseDTO(savedPost != null ? "created" : "fail");
    }
    @GetMapping
    public List<PostDTO> findAll() {
        return postService.findAll();
    }

    @PutMapping("/post")
    public ResponseDTO updatePost(@RequestBody @Valid PostDTO id) {
        boolean updated = postService.updatePost(id);
        return new ResponseDTO(updated ? "updated" : "not found");
    }

    @DeleteMapping("/{id}")
    public ResponseDTO deletePost(@PathVariable("id") Long id) {
        boolean result = postService.deletePost(id);
        return new ResponseDTO(result ? "deleted" : "not found");
    }
}

