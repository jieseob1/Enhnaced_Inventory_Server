package enhanced_inventory.server.service;


import enhanced_inventory.server.domain.User;
import enhanced_inventory.server.dto.UserDto;
import enhanced_inventory.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    } // 단일 생성자는 Autowired 사용 안해도 된다.
    @Transactional(
            readOnly = true
    )
    //유저 찾기, 유저 저장
    public Optional<UserDto> searchUserByUsername(String username) {
        return this.userRepository.findById(username).map(UserDto::from); //이부분 잘 모르곘음
    }

    public UserDto saveUser(String username, String password, String email, String nickname, String memo) {
        return UserDto.from((User) this.userRepository.save(User.of(username, password, email, nickname, memo, username))); // 객체 생성
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
