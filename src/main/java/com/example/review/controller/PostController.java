package com.example.review.controller;

import com.example.review.dto.PostListResponseDto;
import com.example.review.dto.PostResponseDto;
import com.example.review.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostService postService;
    @GetMapping("/posts")
    List<PostListResponseDto> getPostList() {
        return postService.getPostList();
    }

}
