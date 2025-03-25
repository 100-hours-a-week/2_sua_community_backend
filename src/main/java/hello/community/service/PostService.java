package hello.community.service;


import hello.community.domain.Member;
import hello.community.domain.Posts;
import hello.community.dto.PostSaveReqdto;
import hello.community.repository.MemberRepository;
import hello.community.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    //게시글 생성
    public Posts create(PostSaveReqdto postSaveReqdto) {
        //작성자가 없으면 예외 발생하기 나중에 구현해보기

        //게시글 객체 생성
        Posts posts = Posts.builder()
                .id(postSaveReqdto.getUser_id())
                .title(postSaveReqdto.getTitle())
                .content(postSaveReqdto.getContent())
                .build();
        //db에 저장
        return postRepository.save(posts);



                .build()

    }

}
