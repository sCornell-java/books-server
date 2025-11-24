package com.example.books.service;

import com.example.books.entity.Post;
import com.example.books.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post post) {
        String title = post.getTitle() != null ? post.getTitle().trim() : "";
        String content = post.getContent() != null ? post.getContent().trim() : "";

        if (!StringUtils.hasText(title) || !StringUtils.hasText(content)) {
            return null;
        }

        post.setTitle(title);
        post.setContent(content);
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAllByUserId(Long userId) {
        return postRepository.findAllById(userId);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public boolean deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }
}