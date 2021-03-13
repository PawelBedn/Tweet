package bednarowski.pawel.tweet.model.dto;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterUserRequest {

    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    @Length(min = 8, max = 16)
    private String password;
}
