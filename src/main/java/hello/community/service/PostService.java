package hello.community.service;


import hello.community.domain.Member;
import hello.community.domain.Posts;
import hello.community.dto.PostListResponsedto;
import hello.community.dto.PostSaveReqdto;
import hello.community.repository.MemberRepository;
import hello.community.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    //게시글 생성
    public Posts create(PostSaveReqdto postSaveReqdto) {
        //작성자가 없으면 예외 발생하기 나중에 구현해보기
        Member member = memberRepository.findById(postSaveReqdto.getUserId())
                .orElseThrow(() -> new RuntimeException("회원이 존재하지 않습니다."));
        //게시글 객체 생성
        Posts posts = Posts.builder()
                .title(postSaveReqdto.getTitle())
                .content(postSaveReqdto.getContent())
                .member(member)
                .build();
        //db에 저장
        return postRepository.save(posts);

    }

    //게시글조회
    public List<PostListResponsedto> findAllPosts() {
        return postRepository.findAll().stream()
                .map(p -> new PostListResponsedto(
                        p.getId(),
                        p.getMember().getId(),
                        p.getContent(),
                        p.getCreateAt()
                ))
                .collect(Collectors.toList());

    }

}
