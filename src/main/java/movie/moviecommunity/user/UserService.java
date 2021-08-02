package movie.moviecommunity.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public int register(User user){
        validateDuplicateNickName(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateNickName(User user) {
        List<User> findUsers = userRepository.findByNickName(user.getNickname());
        if (!findUsers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }
    }

    @Transactional(readOnly = true)
    public User findUser(int userId){
        return userRepository.findUser(userId);
    }

}
