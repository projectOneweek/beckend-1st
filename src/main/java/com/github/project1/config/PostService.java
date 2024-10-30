package com.github.project1.config;

import com.github.project1.Dto.PostRequest;
import com.github.project1.Dto.PostResponse;
import com.github.project1.entity.PostEntity;
import com.github.project1.entity.UserEntity;
import com.github.project1.respository.PostRepository;
import com.github.project1.respository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private Object PostEntityResponse;

    public void createPost(PostRequest postRequest) {
        UserEntity user = userRepository.findByEmail(postRequest.getAuthor())
                .orElseThrow(() -> new IllegalArgumentException("작성자를 찾을 수 없습니다."));
        PostEntity post = PostEntity.builder()
                .title(postRequest.getTitle())
                .body(postRequest.getContent())
                .user(user)
                .createdAt(LocalDateTime.now())
                .build();
        postRepository.save(post);
    }

    public Collection<PostResponse> getPostsByUserEmail(String authorEmail) {
         return postRepository.findByAuthorEmail(authorEmail).stream()
                 .map((Object post) -> PostResponse.from((PostEntity) post))
                 .collect(Collectors.toList());
    }


    public void updatePost(Long postId, PostRequest postRequest) {
    }
}

