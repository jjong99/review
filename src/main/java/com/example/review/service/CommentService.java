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
import org.springframework.transaction.annotation.Transactional;

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


    @Transactional
    public CommentResponseDto updateComment(User user, Long id, CommentRequestDto commentRequestDto) {
        Comment comment = findComment(id);
        if(!comment.getUser().equals(user)) {
            throw new IllegalArgumentException("댓글 작성자만 수정할 수 있습니다.");
        }
        comment.setBody(commentRequestDto.getBody());
        return new CommentResponseDto(comment);
    }

    public void deleteComment(User user, Long id) {
        Comment comment = findComment(id);
        if(!comment.getUser().equals(user)) {
            throw new IllegalArgumentException("댓글 작성자만 삭제할 수 있습니다.");
        }
        commentRepository.delete(comment);
    }

    public Comment findComment(Long id) {
        return commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
    }


}
