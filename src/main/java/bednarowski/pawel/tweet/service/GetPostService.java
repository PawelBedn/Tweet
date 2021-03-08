package bednarowski.pawel.tweet.service;

import bednarowski.pawel.tweet.model.GetPostConverter;
import bednarowski.pawel.tweet.model.dao.PostEntity;
import bednarowski.pawel.tweet.model.dto.GetPostResponse;
import bednarowski.pawel.tweet.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPostService {

    private final PostRepository postRepository;
    private final GetPostConverter getPostConverter;

    public GetPostResponse getPostById(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return getPostConverter.toDto(postEntity);
    }

    public List<GetPostResponse> getAllPosts() {
        List<GetPostResponse> posts = new ArrayList<>();
        List<PostEntity> postEntities = postRepository.findAll();
        for (PostEntity post : postEntities) {
            GetPostResponse postResponse = getPostConverter.toDto(post);
            posts.add(postResponse);
        }
        return posts;
    }

}
