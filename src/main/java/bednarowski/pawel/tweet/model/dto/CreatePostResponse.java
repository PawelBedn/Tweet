package bednarowski.pawel.tweet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostResponse {

    private Long id;
    private String text;
    private String imagePath;
}
