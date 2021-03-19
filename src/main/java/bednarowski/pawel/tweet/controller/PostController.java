package bednarowski.pawel.tweet.controller;

import bednarowski.pawel.tweet.model.dto.*;
import bednarowski.pawel.tweet.service.CreatePostService;
import bednarowski.pawel.tweet.service.DeletePostService;
import bednarowski.pawel.tweet.service.GetPostService;
import bednarowski.pawel.tweet.service.UpdatePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@Validated
public class PostController {

    private final CreatePostService createPostService;
    private final GetPostService getPostService;
    private final UpdatePostService updatePostService;
    private final DeletePostService deletePostService;

    @PostMapping(path = "/api/post")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePostResponse createPost(@Valid @RequestBody CreatePostRequest request) {
        return createPostService.createPost(request);
    }

    @GetMapping(path = "/api/post/{postId}")
    public GetPostResponse getPostById(@PathVariable("postId") Long id) {
        return getPostService.getPostById(id);
    }


    @PutMapping(path = "/api/posts/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatePostResponse updatePost(@Valid @RequestBody UpdatePostRequest request, @PathVariable("postId") Long id) {
        return updatePostService.update(request, id);
    }

    @DeleteMapping(path = "/api/posts/{postId")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("postId") Long id) {
        deletePostService.delete(id);
    }


}
