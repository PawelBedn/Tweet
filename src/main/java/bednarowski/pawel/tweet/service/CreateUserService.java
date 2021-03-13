package bednarowski.pawel.tweet.service;

import bednarowski.pawel.tweet.model.dao.UserEntity;
import bednarowski.pawel.tweet.model.dto.RegisterUserRequest;
import bednarowski.pawel.tweet.model.dto.UserInfoResponse;
import bednarowski.pawel.tweet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final static String USER_NOT_FOUND = "user with %s email not found";

    public UserInfoResponse saveUser(RegisterUserRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(request.getPassword());
        UserEntity savedEntity = userRepository.save(userEntity);
        return userConverter(savedEntity);

    }

    private UserInfoResponse userConverter(UserEntity userEntity) {
        return UserInfoResponse.builder()
                .username(userEntity.getUsername())
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }
}
