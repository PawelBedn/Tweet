package bednarowski.pawel.tweet.repository;

import bednarowski.pawel.tweet.model.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
