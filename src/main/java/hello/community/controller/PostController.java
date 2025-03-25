package hello.community.controller;

import hello.community.domain.Posts;
import hello.community.dto.PostSaveReqdto;
import hello.community.repository.MemberRepository;
import hello.community.repository.PostRepository;
import hello.community.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostSaveReqdto postSaveReqdto) {
        Posts posts = postService.create(postSaveReqdto);
        return ResponseEntity.ok(posts);
    }



}
