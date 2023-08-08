package enhanced_inventory.server.controller;

import enhanced_inventory.server.domain.User;
import enhanced_inventory.server.dto.UserDto;
import enhanced_inventory.server.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = userService.getAllUsers(); // userService에서 모든 유저 정보들 가지고 온다.
        List<UserDto> userDtos = users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDtos);
    }
//    @PostMapping
//    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
//        User newUser = userService.saveUser(userDto.toEntity());
//        return ResponseEntity.ok(UserDto.from(newUser));
//    }

//    @PutMapping("/{userId}")
//    public ResponseEntity<UserDto> updateUser(@PathVariable String userId, @RequestBody UserDto userDto) {
//        User updatedUser = userService.updateUser(userId, userDto.toEntity());
//        return ResponseEntity.ok(UserDto.from(updatedUser));
//    }

//    @DeleteMapping("/{userId}")
//    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
//        userService.deleteUser(userId);
//        return ResponseEntity.noContent().build();
//    }
}