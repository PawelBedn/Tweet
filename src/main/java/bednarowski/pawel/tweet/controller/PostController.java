package bednarowski.pawel.tweet.controller;

import bednarowski.pawel.tweet.model.dto.CreatePostRequest;
import bednarowski.pawel.tweet.model.dto.CreatePostResponse;
import bednarowski.pawel.tweet.service.CreatePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
public class PostController {

    private final CreatePostService createPostService;

    @PostMapping(path = "/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePostResponse createPost(@RequestBody CreatePostRequest request) {
        return createPostService.createPost(request);
    }
}
