package com.github.project1.Dto;
import com.github.project1.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Long id;
    private String title;
    private String body;
    private String authorEmail;
    private LocalDateTime createdAt;

    public static PostResponse from(PostEntity post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .authorEmail(post.getUser().getEmail()) // User 엔티티의 이메일 참조
                .createdAt(post.getCreatedAt())
                .build();
    }


//        public static PostResponse successMessage() {
//            return PostResponse.builder()
////                    .message("게시물이 성공적으로 작성되었습니다.")
//                    .build();
//    }
}
