package com.example.books.repository;

import com.example.books.entity.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
class PostQuerydslRepositoryTest {

    @Autowired
    private PostQuerydslRepository repository;

    @Sql("/insert-post.sql")
    @DisplayName("findAllByAuthor 테스트")
    @Test
    void findAllByAuthor() {
        String author = "최예진";

        List<Post> result = repository.findAllByAuthor(author);

        assertThat(result)
                .isNotEmpty()
                .allMatch(post -> post.getAuthor().equals(author));
    }

    @Sql("/insert-post.sql")
    @DisplayName("findAll 테스트")
    @Test
    void findAll() {
        List<Post> result = repository.findAll();
        assertThat(result).isNotEmpty();

        Long highestId = result.stream()
                .map(Post::getId)
                .max(Comparator.naturalOrder())
                .orElseThrow();

        assertThat(result.get(0).getId()).isEqualTo(highestId);
    }
}
