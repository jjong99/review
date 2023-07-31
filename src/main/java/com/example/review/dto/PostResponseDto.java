package com.example.review.dto;


import com.example.review.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.username = post.getUser().getUsername();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }

}
