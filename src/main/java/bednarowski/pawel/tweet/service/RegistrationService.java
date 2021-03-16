package bednarowski.pawel.tweet.service;

import bednarowski.pawel.tweet.model.dao.ConfirmationToken;
import bednarowski.pawel.tweet.model.dao.UserEntity;
import bednarowski.pawel.tweet.model.dao.UserRole;
import bednarowski.pawel.tweet.model.dto.RegisterUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidatorService emailValidatorService;
    private final CreateUserService createUserService;
    private final ConfirmationTokenService confirmationTokenService;

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
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token).orElseThrow(() -> new IllegalStateException("Token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        createUserService.enableUser(confirmationToken.getUserEntity().getEmail());
        return "confirmed";
    }
}
