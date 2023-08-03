package com.example.review.service;

import com.example.review.dto.CommentRequestDto;
import com.example.review.dto.CommentResponseDto;
import com.example.review.dto.PostResponseDto;
import com.example.review.entity.Comment;
import com.example.review.entity.Post;
import com.example.review.entity.User;
import com.example.review.repository.CommentRepository;
import com.example.review.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;


    // 댓글 작성
    public CommentResponseDto createComment(User user, CommentRequestDto commentRequestDto) {
        Post post = postService.findPost(commentRequestDto.getPostId());
        Comment comment = new Comment(commentRequestDto.getBody());
        comment.setUser(user);
        comment.setPost(post);
        var savedComment = commentRepository.save(comment);

        return new CommentResponseDto(savedComment);
    }



}
