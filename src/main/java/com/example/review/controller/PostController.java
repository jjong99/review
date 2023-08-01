package com.example.review.controller;

import com.example.review.dto.PostListResponseDto;
import com.example.review.dto.PostRequestDto;
import com.example.review.dto.PostResponseDto;
import com.example.review.security.UserDetailsImpl;
import com.example.review.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/posts")
    PostResponseDto createPost(UserDetailsImpl userDetails, PostRequestDto postRequestDto) {
        return postService.createPost(userDetails.getUser(), postRequestDto);
    }

    @PutMapping("/posts/{id}/update")
    PostResponseDto updatePost(UserDetailsImpl userDetails, Long id, PostRequestDto postRequestDto) {
        return postService.updatePost(userDetails.getUser(), id, postRequestDto);
    }

}
