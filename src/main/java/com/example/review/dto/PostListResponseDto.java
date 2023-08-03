package com.example.review.dto;

import com.example.review.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostListResponseDto {
    private Long id;
    private String title;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public PostListResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.username = post.getUser().getUsername();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }
}
