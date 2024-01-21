package enhanced_inventory.server.service;


import enhanced_inventory.server.entity.User;
import enhanced_inventory.server.dto.UserDto;
import enhanced_inventory.server.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;


    @Transactional
    public UserDto updateUser(String userId, UserDto userDto) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));

        //Todo. 추후 User에 맞춰 변경 예정
        user.setUserPassword(userDto.userPassword());
        user.setEmail(userDto.email());
        user.setEmail(userDto.role());
        user.setEmail(userDto.memo());
        user.setEmail(userDto.companyId());

        User updatedUser = userRepository.save(user);
        return UserDto.from(updatedUser);
    }


//    public String saveUser(UserDto userDto) {
//        User user = userDto.toEntity();
//        this.userRepository.save(user);
//        return "ok";
//    }
public UserDto saveUser(String username, String password, String email, String role, String memo, String companyId) {
    return UserDto.from((User)this.userRepository.save(User.of(username, password, email, role, memo, companyId)));
}


    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
