package com.example.review.service;

import com.example.review.dto.PostListResponseDto;
import com.example.review.dto.PostRequestDto;
import com.example.review.dto.PostResponseDto;
import com.example.review.entity.Post;
import com.example.review.entity.User;
import com.example.review.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public PostResponseDto updatePost(User user, Long id, PostRequestDto postRequestDto) {
        Post post = findPost(id);
        // 작성자 확인
        if(!post.getUser().equals(user)) {
            throw new IllegalArgumentException("게시글 작성자만 수정할 수 있습니다.");
        }

        post.setTitle(postRequestDto.getTitle());
        post.setContent(postRequestDto.getContent());

        return new PostResponseDto(post);
    }

    // 게시글 삭제
    @Transactional
    public void deletePost(User user, Long id) {
        Post post = findPost(id);
        if(!user.equals(post.getUser())) {
            throw new IllegalArgumentException("게시글 작성자만 삭제할 수 있습니다.");
        }

        postRepository.delete(post);
    }

    public Post findPost(long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
    }


}
