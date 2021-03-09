package bednarowski.pawel.tweet.model.dto;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {

    @NotNull
    private String username;

    @NotNull
    @Length(min = 8, max = 16)
    private String password;
}
