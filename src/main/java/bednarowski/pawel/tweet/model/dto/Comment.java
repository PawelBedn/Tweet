package bednarowski.pawel.tweet.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Comment {
    private String content;
}
