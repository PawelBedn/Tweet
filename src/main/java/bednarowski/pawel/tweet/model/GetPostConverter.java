package bednarowski.pawel.tweet.model;

import bednarowski.pawel.tweet.model.dao.PostEntity;
import bednarowski.pawel.tweet.model.dto.GetPostResponse;

public class GetPostConverter implements Convertable<Void, PostEntity, GetPostResponse> {

    @Override
    public PostEntity fromDto(Void input) {
        throw new UnsupportedOperationException("invalid operation");
    }

    @Override
    public GetPostResponse toDto(PostEntity postEntity) {
        return GetPostResponse.builder()
                .id(postEntity.getId())
                .text(postEntity.getText())
                .imagePath(postEntity.getImagePath())
                .build();
    }
}
