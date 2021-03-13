package bednarowski.pawel.tweet.service;

import bednarowski.pawel.tweet.model.dto.RegisterUserRequest;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public static String register(RegisterUserRequest request) {
        return "it works";
    }
}
