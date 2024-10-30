package com.github.project1.respository;


import com.github.project1.config.Post;
import com.github.project1.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByUserEmail(String email);

    Collection<Object> findByAuthorEmail(String authorEmail);
}

