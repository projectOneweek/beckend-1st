package com.github.demo123456.config.demo123456.repository;

import com.github.demo123456.config.demo123456.entity.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private final JdbcTemplate jdbcTemplate;

    public CommentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper 구현 - ResultSet을 Comment 객체로 변환
    private final RowMapper<Comment> commentRowMapper = (rs, rowNum) -> {
        Comment comment = new Comment();
        comment.setId(rs.getLong("id"));
        comment.setContent(rs.getString("content"));
        comment.setAuthor(rs.getString("author"));
        comment.setPostId(rs.getLong("post_id"));
        return comment;
    };

    // 모든 댓글 조회
    @Override
    public List<Comment> findAllComments() {
        String sql = "SELECT * FROM comments";
        return jdbcTemplate.query(sql, commentRowMapper);
    }

    // 댓글 저장
    @Override
    public Integer saveComment(Comment comment) {
        String sql = "INSERT INTO comments (content, author, post_id) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, comment.getContent(), comment.getAuthor(), comment.getPostId());
    }

    // 댓글 수정
    @Override
    public Comment updateComment(Integer id, Comment comment) {
        String sql = "UPDATE comments SET content = ?, author = ? WHERE id = ?";
        jdbcTemplate.update(sql, comment.getContent(), comment.getAuthor(), id);
        comment.setId(Long.valueOf(id));
        return comment;
    }

    // ID로 댓글 조회
    @Override
    public Optional<Comment> findCommentById(Long id) {
        String sql = "SELECT * FROM comments WHERE id = ?";
        List<Comment> results = jdbcTemplate.query(sql, commentRowMapper, id);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    // ID로 댓글 삭제
    @Override
    public void deleteCommentById(Long id) {
        String sql = "DELETE FROM comments WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // 댓글 내용 업데이트
    @Override
    public void updateCommentContent(Long commentId, String content) {
        String sql = "UPDATE comments SET content = ? WHERE id = ?";
        jdbcTemplate.update(sql, content, commentId);
    }
}

