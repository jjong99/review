package com.example.review.controller;

import com.example.review.dto.PostListResponseDto;
import com.example.review.dto.PostRequestDto;
import com.example.review.dto.PostResponseDto;
import com.example.review.security.UserDetailsImpl;
import com.example.review.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    //게시글 단건 조회
    @GetMapping("/posts/{id}")
    PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PostMapping("/posts")
    PostResponseDto createPost(@AuthenticationPrincipal UserDetailsImpl userDetails, PostRequestDto postRequestDto) {
        return postService.createPost(userDetails.getUser(), postRequestDto);
    }

    @PutMapping("/posts/{id}")
    PostResponseDto updatePost(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id, PostRequestDto postRequestDto) {
        return postService.updatePost(userDetails.getUser(), id, postRequestDto);
    }

    @DeleteMapping("/posts/{id}")
    void deletePost(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id) {
        postService.deletePost(userDetails.getUser(), id);
    }

}
