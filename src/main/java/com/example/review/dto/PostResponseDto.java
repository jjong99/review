package com.example.review.dto;


import com.example.review.entity.Comment;
import com.example.review.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Set<CommentResponseDto> comments;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.username = post.getUser().getUsername();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.comments = post.getComments().stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toSet());
    }

}
