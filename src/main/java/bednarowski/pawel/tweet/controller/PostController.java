package bednarowski.pawel.tweet.controller;

import bednarowski.pawel.tweet.model.dto.CreatePostRequest;
import bednarowski.pawel.tweet.model.dto.CreatePostResponse;
import bednarowski.pawel.tweet.model.dto.GetPostResponse;
import bednarowski.pawel.tweet.service.CreatePostService;
import bednarowski.pawel.tweet.service.GetPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class PostController {

    private final CreatePostService createPostService;
    private final GetPostService getPostService;

    @PostMapping(path = "/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePostResponse createPost(@RequestBody CreatePostRequest request) {
        return createPostService.createPost(request);
    }

    @GetMapping(path = "post/{postId}")
    public GetPostResponse getPostById(@PathVariable("postId") Long id) {
        return getPostService.getPostById(id);
    }
    @GetMapping(path = "/posts")
    public List<GetPostResponse> getAllPosts() {
        return getPostService.getAllPosts();
    }
}
