package enhanced_inventory.server.controller;

import enhanced_inventory.server.domain.User;
import enhanced_inventory.server.dto.UserDto;
import enhanced_inventory.server.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;


    @GetMapping("/findAll")
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers(); // userService에서 모든 유저 정보들 가지고 온다.
        return users;
    }
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        UserDto newUser = userService.saveUser(userDto);
        return newUser;
    }

    @PutMapping("/{userid}")
    public UserDto updateUser(@PathVariable String userId, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUser(userId,userDto);
        return updatedUser;
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}