package com.example.review.dto;

import com.example.review.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentResponseDto {
    private String username;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CommentResponseDto(Comment comment) {
        super();
        this.body = comment.getBody();
        this.username = comment.getUser().getUsername();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }

}
