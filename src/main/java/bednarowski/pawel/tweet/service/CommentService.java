package bednarowski.pawel.tweet.service;


import bednarowski.pawel.tweet.model.dao.CommentEntity;
import bednarowski.pawel.tweet.model.dto.CreateCommentRequest;
import bednarowski.pawel.tweet.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;


    public CommentEntity addComment(CreateCommentRequest request) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setContent(request.getContent());
        return commentRepository.save(commentEntity);
    }
}
