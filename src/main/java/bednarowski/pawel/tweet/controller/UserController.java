package bednarowski.pawel.tweet.controller;

import bednarowski.pawel.tweet.model.dto.RegisterUserRequest;
import bednarowski.pawel.tweet.model.dto.UserInfoResponse;
import bednarowski.pawel.tweet.service.CreateUserService;
import bednarowski.pawel.tweet.service.GetUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class UserController {

    private final CreateUserService createUserService;
    private final GetUserService getUserService;

    @PostMapping(path = "/pi/users")
    public UserInfoResponse createUser(@Valid @RequestBody RegisterUserRequest request) {
        return createUserService.saveUser(request);
    }

    @GetMapping(path = "/api/users/{username}")
    public UserInfoResponse getUserByUsername(@PathVariable("username") String username) {
        return getUserService.getUserByUsername(username);
    }
}
