package com.example.books.controller;

import com.example.books.base.BaseController;
import com.example.books.entity.Post;
import com.example.books.repository.PostQuerydslRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

class PostControllerTest extends BaseController {
    @Autowired
    private PostQuerydslRepository postQuerydslRepository;

    @Sql("/insert-post.sql")
    @DisplayName("post findAll")
    @Test
    void findAll() throws Exception {
        final String url = "/post";
        Post post = postQuerydslRepository.findById(21L)
                .orElse(null);

        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                        .get(url)
                        .accept(MediaType.APPLICATION_JSON)
        );

        resultActions
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                )
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$[0].id").value(post.getId())
                )
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$[0].title").value(post.getTitle())
                );
    }
}