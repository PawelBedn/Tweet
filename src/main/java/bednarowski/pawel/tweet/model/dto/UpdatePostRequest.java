package bednarowski.pawel.tweet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostRequest {

    private Long id;

    @NotNull
    private String text;
    private String imagePath;
}
