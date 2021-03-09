package bednarowski.pawel.tweet.service;

import bednarowski.pawel.tweet.model.dao.UserEntity;
import bednarowski.pawel.tweet.model.dto.UserInfoResponse;
import bednarowski.pawel.tweet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserService {

    private final UserRepository userRepository;

    public UserInfoResponse getUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException());
        return UserInfoResponse.builder().username(userEntity.getUsername()).build();
    }
}
