package com.example.books.repository;

import com.example.books.entity.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.books.entity.QPost.post;

@Repository
@RequiredArgsConstructor
public class PostQuerydslRepositoryImpl implements PostQuerydslRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Post> findAllByAuthor(String author) {
        return queryFactory
                .selectFrom(post)
                .where(post.title.like(author))
                .fetch();
    }
}