package com.example.books.service;

import com.example.books.entity.Post;
import com.example.books.repository.PostQuerydslRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.books.dto.PostDTO;
import com.example.books.dto.PostRequestDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostQuerydslRepository postQuerydslRepository;

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


        Post saved = postQuerydslRepository.save(post);

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
    public List<PostDTO> findAll() {
        return postQuerydslRepository.findAll().stream().map(p -> {
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
        Optional<Post> optional = postQuerydslRepository.findById(dto.getId());
        if (optional.isPresent()) {
            Post post = optional.get();
            post.setTitle(dto.getTitle());
            post.setContent(dto.getContent());
            post.setAuthor(dto.getAuthor());
            post.setRating(dto.getRating());
            postQuerydslRepository.save(post);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePost(Long id) {
        if (postQuerydslRepository.existsById(id)) {
            postQuerydslRepository.deleteById(id);
            return true;
        }
        return false;
    }
}