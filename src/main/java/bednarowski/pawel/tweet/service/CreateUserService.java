package bednarowski.pawel.tweet.service;

import bednarowski.pawel.tweet.model.dao.UserEntity;
import bednarowski.pawel.tweet.model.dto.RegisterUserRequest;
import bednarowski.pawel.tweet.model.dto.UserInfoResponse;
import bednarowski.pawel.tweet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserRepository userRepository;

    public UserInfoResponse saveUser(RegisterUserRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(request.getPassword());
        UserEntity savedEntity = userRepository.save(userEntity);
        return userConverter(savedEntity);

    }

    private UserInfoResponse userConverter(UserEntity userEntity) {
        return UserInfoResponse.builder()
                .username(userEntity.getUsername())
                .build();
    }
}
