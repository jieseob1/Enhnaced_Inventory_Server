package enhanced_inventory.server.service;


import enhanced_inventory.server.domain.User;
import enhanced_inventory.server.dto.UserDto;
import enhanced_inventory.server.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository; // DI


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


    public UserDto saveUser(UserDto userDto) {
        User user = userDto.toEntity();
        return UserDto.from(this.userRepository.save(user));
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
