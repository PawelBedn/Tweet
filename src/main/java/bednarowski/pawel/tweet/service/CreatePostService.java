package bednarowski.pawel.tweet.service;

import bednarowski.pawel.tweet.controller.UploadController;
import bednarowski.pawel.tweet.model.CreatePostConverter;
import bednarowski.pawel.tweet.model.dao.PostEntity;
import bednarowski.pawel.tweet.model.dto.CreatePostRequest;
import bednarowski.pawel.tweet.model.dto.CreatePostResponse;
import bednarowski.pawel.tweet.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePostService {

    private final PostRepository postRepository;
    private final CreatePostConverter createPostConverter;

    public CreatePostResponse createPost(CreatePostRequest request) {
        PostEntity createdPost = postRepository.save(createPostConverter.fromDto(request));
        return createPostConverter.toDto(createdPost);
    }
}
