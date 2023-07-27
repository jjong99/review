package com.example.review.repository;

import com.example.review.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository {
    List<Post> findAllByOrderByCreatedAtDesc();

}
