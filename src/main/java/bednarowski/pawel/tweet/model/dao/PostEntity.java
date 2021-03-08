package bednarowski.pawel.tweet.model.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String text;

    @Column
    private String imagePath;

}
