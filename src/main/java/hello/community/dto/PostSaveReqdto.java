package hello.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSaveReqdto {
//사용자가 요청하는 값
    Long userId;
    String title;
    String content;
    String image_url;
}
