package bednarowski.pawel.tweet.controller;

import bednarowski.pawel.tweet.model.dto.RegisterUserRequest;
import bednarowski.pawel.tweet.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    private String register(RegisterUserRequest request) {
        return RegistrationService.register(request);
    }
}
