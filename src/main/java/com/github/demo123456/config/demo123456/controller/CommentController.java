package com.github.demo123456.config.demo123456.controller;

import com.github.demo123456.config.demo123456.entity.Comment;
import com.github.demo123456.config.demo123456.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 특정 ID의 댓글 조회 API
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCommentById(@PathVariable Long id) {
        Optional<Comment> comment = commentService.getCommentById(id);

        Map<String, Object> response = new HashMap<>();
        if (comment.isPresent()) {
            response.put("message", "댓글 조회 성공");
            response.put("data", comment.get());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "댓글을 찾을 수 없습니다.");
            return ResponseEntity.status(404).body(response);
        }
    }

    // 모든 댓글 조회 API
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllComments() {
        List<Comment> comments = commentService.getAllComments();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "모든 댓글 조회 성공");
        response.put("data", comments);
        return ResponseEntity.ok(response);
    }

    // 댓글 생성 API
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createComment(@RequestBody Comment comment) {
        Comment savedComment = commentService.createComment(comment);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "댓글이 성공적으로 작성되었습니다.");
        response.put("commentId", savedComment.getId());

        return ResponseEntity.ok(response);
    }

    // 댓글 업데이트 API
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        Comment updatedComment = commentService.updateComment(id, comment);

        Map<String, Object> response = new HashMap<>();
        if (updatedComment != null) {
            response.put("message", "댓글이 성공적으로 수정되었습니다.");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "댓글을 찾을 수 없습니다.");
            return ResponseEntity.status(404).body(response);
        }
    }

    // 댓글 삭제 API
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteComment(@PathVariable Long id) {
        boolean deleted = commentService.deleteComment(id);

        Map<String, Object> response = new HashMap<>();
        if (deleted) {
            response.put("message", "댓글이 성공적으로 삭제되었습니다.");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "댓글을 찾을 수 없습니다.");
            return ResponseEntity.status(404).body(response);
        }
    }
}



