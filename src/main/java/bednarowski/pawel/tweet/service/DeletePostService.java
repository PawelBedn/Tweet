package bednarowski.pawel.tweet.service;


import bednarowski.pawel.tweet.model.dao.PostEntity;
import bednarowski.pawel.tweet.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePostService {

    private final PostRepository postRepository;

    public void delete(Long id) {
        PostEntity postToDelete = postRepository.findById(id).orElseThrow(() -> new RuntimeException());
        postRepository.delete(postToDelete);
    }
}
