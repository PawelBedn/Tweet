package bednarowski.pawel.tweet.model;

import bednarowski.pawel.tweet.model.dao.PostEntity;
import bednarowski.pawel.tweet.model.dto.CreatePostRequest;
import bednarowski.pawel.tweet.model.dto.CreatePostResponse;
import org.springframework.stereotype.Service;

@Service
public class CreatePostConverter implements Convertable<CreatePostRequest, PostEntity, CreatePostResponse> {

    @Override
    public PostEntity fromDto(CreatePostRequest input) {
        PostEntity postEntity = new PostEntity();
        postEntity.setText(input.getText());
        postEntity.setImagePath(input.getImagePath());
        return postEntity;
    }

    @Override
    public CreatePostResponse toDto(PostEntity postEntity) {
        return CreatePostResponse.builder()
                .id(postEntity.getId())
                .text(postEntity.getText())
                .imagePath(postEntity.getImagePath())
                .build();
    }
}
