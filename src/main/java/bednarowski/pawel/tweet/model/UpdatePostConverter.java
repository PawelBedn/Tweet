package bednarowski.pawel.tweet.model;

import bednarowski.pawel.tweet.model.dao.PostEntity;
import bednarowski.pawel.tweet.model.dto.GetPostResponse;
import bednarowski.pawel.tweet.model.dto.UpdatePostResponse;
import org.springframework.stereotype.Service;

@Service
public class UpdatePostConverter implements Convertable<Void, PostEntity, UpdatePostResponse> {

    @Override
    public PostEntity fromDto(Void input) {
        throw new UnsupportedOperationException("invalid operation");
    }

    @Override
    public UpdatePostResponse toDto(PostEntity postEntity) {
        return UpdatePostResponse.builder()
                .id(postEntity.getId())
                .text(postEntity.getText())
                .imagePath(postEntity.getImagePath())
                .build();
    }
}
