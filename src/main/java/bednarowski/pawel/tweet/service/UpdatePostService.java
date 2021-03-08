package bednarowski.pawel.tweet.service;


import bednarowski.pawel.tweet.model.UpdatePostConverter;
import bednarowski.pawel.tweet.model.dao.PostEntity;
import bednarowski.pawel.tweet.model.dto.UpdatePostRequest;
import bednarowski.pawel.tweet.model.dto.UpdatePostResponse;
import bednarowski.pawel.tweet.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePostService {

    private final PostRepository postRepository;
    private final UpdatePostConverter updatePostConverter;

    public UpdatePostResponse update(UpdatePostRequest request, Long id) {
        PostEntity postToUpdate = postRepository.findById(id).orElseThrow(() -> new RuntimeException());
        postToUpdate.setText(request.getText());
        postToUpdate.setImagePath(request.getImagePath());
        return updatePostConverter.toDto(postToUpdate);
    }
}
