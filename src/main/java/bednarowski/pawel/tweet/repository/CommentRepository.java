package bednarowski.pawel.tweet.repository;

import bednarowski.pawel.tweet.model.dao.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
