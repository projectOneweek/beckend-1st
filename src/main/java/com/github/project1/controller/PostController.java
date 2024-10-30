package com.github.project1.controller;

import com.github.project1.Dto.PostRequest;
import com.github.project1.Dto.PostResponse;
import com.github.project1.config.PostService;
import com.github.project1.entity.PostEntity;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/search")
    public ResponseEntity<List<PostResponse>> getPostsByUserEmail(@RequestParam String author_email) {
        List<PostResponse> posts = postService.getPostsByUserEmail(author_email).stream()
                .map((Object post) -> PostResponse.from((PostEntity) post))
                .collect(Collectors.toList());
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest) {
            postService.createPost(postRequest);
            PostResponse response = new PostResponse();
//            ("게시물이 성공적으로 작성되었습니다.");
            return ResponseEntity.ok(response);
        }
    @PutMapping("/{post_id}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable Long post_id, @RequestBody PostRequest postRequest) {
        postService.updatePost(post_id, postRequest); PostResponse response = new PostResponse();
        return ResponseEntity.ok(response);
    }
}











//@RestController
//@RequestMapping ("/api/v1/posts")
//@RequiredArgsConstructor
//
//public class PostController {
//    private final PostService postService;
//
//    @PostMapping
//        public ResponseEntity<PostResponse> writePost(
//            AutoInfo authInfo,
//            @RequestBody PostRequest postRequest
//    ){
//        Post post = postService.writePost(postRequest.getTitle(), postRequest.getBody)
//                return ResponseEntity.ok(PostResponse.from(post));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<PostResponse>> getPosts(AutoInfo autoInfo){
//        return ResponseEntity.ok(
//                postService.getAllPosts().stream()
//                        .map(PostResponse::from)
//                        .collect(Collectors.toList())
//        );
//    }
//}

