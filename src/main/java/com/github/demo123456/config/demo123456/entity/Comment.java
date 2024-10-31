package com.github.demo123456.config.demo123456.entity;//package com.github.project1.entity;


public class Comment {

    private Long id;
    private String content;
    private String author;
    private Long postId;

    // 생성자
    public Comment() {
    }

    public Comment(Long id, String content, String author, Long postId) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.postId = postId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }


}
