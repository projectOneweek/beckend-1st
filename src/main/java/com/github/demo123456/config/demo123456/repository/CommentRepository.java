package com.github.demo123456.config.demo123456.repository;

import com.github.demo123456.config.demo123456.entity.Comment;
import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    List<Comment> findAllComments();
    Integer saveComment(Comment comment);
    Comment updateComment(Integer id, Comment comment);
    Optional<Comment> findCommentById(Long id);
    void deleteCommentById(Long id);
    void updateCommentContent(Long commentId, String content);
}



