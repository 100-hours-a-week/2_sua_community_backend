package hello.community.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)


public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int views = 0;

    @Column(nullable = false)
    private int likes = 0;

    @Column(nullable = false)
    private int comments = 0;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updateAt;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createAt;

    @Column
    private LocalDateTime DeleteAt;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
