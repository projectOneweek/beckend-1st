package com.github.project1.Service;

import com.github.project1.entity.PostEntity;
import com.github.project1.respository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public List<PostEntity> getPostsByUserEmail(String email) {
        return postRepository.findByUserEmail(email);
    }
}
