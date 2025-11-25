package com.example.books.service;

import com.example.books.dto.*;
import com.example.books.entity.Post;
import com.example.books.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public PostDTO createPost(PostRequestDTO dto) {
        String title = dto.getTitle() != null ? dto.getTitle().trim() : "";
        String content = dto.getContent() != null ? dto.getContent().trim() : "";

        if (!StringUtils.hasText(title) || !StringUtils.hasText(content)) {
            return null;
        }

        Post post = Post.builder()
                .title(title)
                .content(content)
                .author(dto.getAuthor())
                .rating(dto.getRating())
                .build();


        Post saved = postRepository.save(post);

        return new PostDTO(
                saved.getId(),
                saved.getTitle(),
                saved.getContent(),
                saved.getAuthor(),
                saved.getRating(),
                saved.getCreatedAt()
        );
    }

    @Override
    public List<PostDTO> findAllByUserId(Long userId) {
        List<Post> posts = postRepository.findAllById(userId);

        return posts.stream()
                .map(p -> new PostDTO(
                        p.getId(),
                        p.getTitle(),
                        p.getContent(),
                        p.getAuthor(),
                        p.getRating(),
                        p.getCreatedAt()))
                .toList();
    }

    @Override
    public List<PostDTO> findAll() {
        return postRepository.findAll().stream().map(p -> {
            PostDTO dto = new PostDTO();
            dto.setId(p.getId());
            dto.setTitle(p.getTitle());
            dto.setContent(p.getContent());
            dto.setAuthor(p.getAuthor());
            dto.setRating(p.getRating());
            dto.setCreatedAt(p.getCreatedAt());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public boolean updatePost(PostDTO dto) {
        Optional<Post> optional = postRepository.findById(dto.getId());
        if (optional.isPresent()) {
            Post post = optional.get();
            post.setTitle(dto.getTitle());
            post.setContent(dto.getContent());
            post.setAuthor(dto.getAuthor());
            post.setRating(dto.getRating());
            postRepository.save(post);
            return true;
        }
        return false;
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