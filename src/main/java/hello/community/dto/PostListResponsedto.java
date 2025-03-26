package hello.community.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostListResponsedto {
    private Long postId;
    private Long userId;
    private String title;
    private LocalDateTime createAt;
}
