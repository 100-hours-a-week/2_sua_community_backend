package hello.community.repository;

import hello.community.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Posts, Long> {
    Optional<Posts> findByTitle(String title);
}