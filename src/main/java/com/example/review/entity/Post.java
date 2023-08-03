package com.example.review.entity;

import com.example.review.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<Comment> comments = new ArrayList<>();
    private Set<Comment> comments = new LinkedHashSet<>();


    public Post(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
