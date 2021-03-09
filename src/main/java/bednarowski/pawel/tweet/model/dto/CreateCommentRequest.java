package bednarowski.pawel.tweet.model.dto;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequest {
    private String content;
}
