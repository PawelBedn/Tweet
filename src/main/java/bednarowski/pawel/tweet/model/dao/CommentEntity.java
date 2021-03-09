package bednarowski.pawel.tweet.model.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity owner;

    private String content;

}
