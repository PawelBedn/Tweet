package bednarowski.pawel.tweet.controller;

import bednarowski.pawel.tweet.model.dto.CreateCommentRequest;
import bednarowski.pawel.tweet.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/api/comment")
    public void addComment(CreateCommentRequest request) {
        commentService.addComment(request);
    }
}
