package bednarowski.pawel.tweet.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetPostResponse {

    private Long id;
    private String text;
    private String imagePath;
}
