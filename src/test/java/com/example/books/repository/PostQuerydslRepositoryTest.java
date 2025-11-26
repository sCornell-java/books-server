package com.example.books.repository;

import com.example.books.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostQuerydslRepositoryTest {

    @Autowired
    private PostQuerydslRepository repository;

    @Sql("/insert-post.sql")
    @Test
    void findAllByAuthor() {
        String author = "최예진";

        List<Post> result = repository.findAllByAuthor(author);

        assertThat(result)
                .isNotEmpty()
                .allMatch(post -> post.getAuthor().equals(author));
    }
}