package bednarowski.pawel.tweet.repository;

import bednarowski.pawel.tweet.model.dao.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
