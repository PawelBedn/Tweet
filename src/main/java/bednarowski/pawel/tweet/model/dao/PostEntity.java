package bednarowski.pawel.tweet.model.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String imagePath;

}
