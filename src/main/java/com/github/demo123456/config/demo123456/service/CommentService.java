package com.github.demo123456.config.demo123456.service;

import com.github.demo123456.config.demo123456.entity.Comment;
import com.github.demo123456.config.demo123456.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // 댓글 생성
    public Comment createComment(Comment comment) {
        commentRepository.saveComment(comment);
        return comment;
    }

    // 댓글 ID로 조회
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findCommentById(id);
    }

    // 모든 댓글 조회
    public List<Comment> getAllComments() {
        return commentRepository.findAllComments();
    }

    // 댓글 수정
    public Comment updateComment(Long id, Comment updatedComment) {
        return commentRepository.updateComment(id.intValue(), updatedComment);
    }

    // 댓글 삭제
    public boolean deleteComment(Long id) {
        commentRepository.deleteCommentById(id);
        return true;
    }

    // 댓글 내용 업데이트
    public void updateCommentContent(Long commentId, String content) {
        commentRepository.updateCommentContent(commentId, content);
    }
}
