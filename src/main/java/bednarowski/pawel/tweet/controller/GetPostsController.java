package bednarowski.pawel.tweet.controller;

import bednarowski.pawel.tweet.model.dto.GetPostResponse;
import bednarowski.pawel.tweet.service.GetPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GetPostsController {

    private final GetPostService getPostService;

    @GetMapping("/api/posts")
    public String getAllPosts(Model model) {
        List<GetPostResponse> posts = getPostService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }
}
