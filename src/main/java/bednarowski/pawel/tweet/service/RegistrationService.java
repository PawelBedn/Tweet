package bednarowski.pawel.tweet.service;

import bednarowski.pawel.tweet.model.dao.UserEntity;
import bednarowski.pawel.tweet.model.dao.UserRole;
import bednarowski.pawel.tweet.model.dto.RegisterUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidatorService emailValidatorService;
    private final CreateUserService createUserService;

    public String register(RegisterUserRequest request) {
        boolean isValidEmail = emailValidatorService.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return createUserService.signUpUser(new UserEntity(
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                UserRole.USER
       ));
      //  "works";
    }
}
