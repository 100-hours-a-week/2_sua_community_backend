package hello.community.controller;

import hello.community.domain.Posts;
import hello.community.dto.PostListResponsedto;
import hello.community.dto.PostSaveReqdto;
import hello.community.repository.MemberRepository;
import hello.community.repository.PostRepository;
import hello.community.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostSaveReqdto postSaveReqdto) {
        Posts posts = postService.create(postSaveReqdto);
        return ResponseEntity.ok(posts);
    }

    @GetMapping
    public ResponseEntity<List<PostListResponsedto>> findAllPosts() {
        List<PostListResponsedto> postList = postService.findAllPosts();
        return ResponseEntity.ok(postList);
    }
}