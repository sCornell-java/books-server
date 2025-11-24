package com.example.books.service;

import com.example.books.DTO.PostRequestDto;
import com.example.books.dto.PostDTO;
import com.example.books.entity.Post;
import com.example.books.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public PostDTO createPost(PostRequestDto dto) {
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
        List<Post> posts = postRepository.findAll();

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
    public boolean deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }
}