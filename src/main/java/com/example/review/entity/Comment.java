package com.example.review.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(String body) {
        this.body = body;
    }



    public void setPost(Post post) {
        this.post = post;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
