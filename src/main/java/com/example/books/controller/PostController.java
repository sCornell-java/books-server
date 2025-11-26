package com.example.books.controller;

import com.example.books.dto.PostDTO;
import com.example.books.dto.PostRequestDTO;
import com.example.books.dto.ResponseDTO;
import com.example.books.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseDTO createPost(@Valid @RequestBody PostRequestDTO postRequest) {
        PostDTO savedPost = postService.createPost(postRequest);
        return new ResponseDTO(savedPost != null ? "created" : "fail");
    }

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/author")
    public List<PostDTO> getPostsByAuthor(@RequestParam("author") String author) {
        return postService.findAllByAuthor(author);
    }

    @PutMapping
    public ResponseDTO updatePost(@Valid @RequestBody PostDTO postDTO) {
        boolean updated = postService.updatePost(postDTO);
        return new ResponseDTO(updated ? "updated" : "not found");
    }

    @DeleteMapping("/{id}")
    public ResponseDTO deletePost(@PathVariable Long id) {
        boolean deleted = postService.deletePost(id);
        return new ResponseDTO(deleted ? "deleted" : "not found");
    }
}
