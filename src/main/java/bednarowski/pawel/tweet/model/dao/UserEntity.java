package bednarowski.pawel.tweet.model.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @OneToMany
    private List<CommentEntity> comments;
}
