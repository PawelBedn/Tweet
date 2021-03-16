package bednarowski.pawel.tweet.model.dto;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class RegisterUserRequest {

    private final String username;
    private final String email;
    private final String password;
}
