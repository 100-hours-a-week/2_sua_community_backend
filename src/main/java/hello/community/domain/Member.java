package hello.community.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter  //Date 를 쓰면 불필요한 메서드까지 생성되어 Getter만 사용하는것
public class Member {

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //enum기능 넣기(user 아니면 admin이 있다고만 가정하고 실제로는 사용하지 않을 것이다.)
    //기본값을 user로 깔아줄 것이다.

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.USER;
}




