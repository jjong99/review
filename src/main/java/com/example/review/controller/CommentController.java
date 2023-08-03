package com.example.review.controller;

import com.example.review.dto.CommentRequestDto;
import com.example.review.dto.CommentResponseDto;
import com.example.review.dto.PostResponseDto;
import com.example.review.security.UserDetailsImpl;
import com.example.review.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    CommentResponseDto createComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.createComment(userDetails.getUser(), commentRequestDto);

    }

}
