package hello.community.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter

public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int views;

    @Column(nullable = false)
    private int likes;

    @Column(nullable = false)
    private int comments;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime UpdateAt;

    @CreatedDate
    //처음에는 저장을하고 그 후엔 하지 않겠다.
    @Column(nullable = false,updatable = false)
    private LocalDateTime CreateAt;

    @Column
    private LocalDateTime DeleteAt;

}
