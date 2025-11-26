package com.example.books.repository;

import com.example.books.entity.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.books.entity.QPost.post;

@Repository
@RequiredArgsConstructor
public class PostQuerydslRepositoryImpl implements PostQuerydslRepository {

    private final JPAQueryFactory queryFactory;
    private final EntityManager em;

    @Override
    public List<Post> findAllByAuthor(String author) {
        return queryFactory
                .selectFrom(post)
                .where(post.author.eq(author))
                .fetch();
    }

    @Override
    public Post save(Post entity) {
        if (entity.getId() == null) {
            em.persist(entity);
            return entity;
        } else {
            return em.merge(entity);
        }
    }

    @Override
    public List<Post> findAll() {
        return queryFactory
                .selectFrom(post)
                .orderBy(post.id.desc())
                .fetch();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(em.find(Post.class, id));
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(em::remove);
    }
}
