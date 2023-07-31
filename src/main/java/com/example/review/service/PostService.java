package com.example.review.service;

import com.example.review.dto.PostListResponseDto;
import com.example.review.dto.PostRequestDto;
import com.example.review.dto.PostResponseDto;
import com.example.review.entity.Post;
import com.example.review.entity.User;
import com.example.review.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    //게시글 전체 조회
    public List<PostListResponseDto> getPostList() {
        return postRepository.findAllByOrderByCreatedAtDesc().stream().map(PostListResponseDto::new).collect(Collectors.toList());
    }

    // 게시글 작성
    public PostResponseDto createPost(User user, PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        post.setUser(user);
        postRepository.save(post);
        return new PostResponseDto(post);
    }
}
