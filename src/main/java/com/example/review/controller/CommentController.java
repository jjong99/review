package com.example.review.controller;

import com.example.review.dto.CommentRequestDto;
import com.example.review.dto.CommentResponseDto;
import com.example.review.dto.PostResponseDto;
import com.example.review.security.UserDetailsImpl;
import com.example.review.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    CommentResponseDto createComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.createComment(userDetails.getUser(), commentRequestDto);

    }

    @PutMapping("/comments/{id}")
    CommentResponseDto updateComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(userDetails.getUser(), id, commentRequestDto);
    }

    @DeleteMapping("/comments/{id}")
    void deleteComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id) {
        commentService.deleteComment(userDetails.getUser(), id);
    }

}
