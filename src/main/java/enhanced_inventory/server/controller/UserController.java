package enhanced_inventory.server.controller;

import enhanced_inventory.server.domain.User;
import enhanced_inventory.server.dto.UserDto;
import enhanced_inventory.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/findAll")
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers(); // userService에서 모든 유저 정보들 가지고 온다.
        return users;
    }
    @PostMapping("/signup")
    public UserDto createUser(@RequestBody User user) {
        //fix later
        log.info("createUser requestBody = {}", user);
        UserDto newUser = userService.saveUser(
            user.getId(),
            user.getUserPassword(),
            user.getEmail(),
            user.getRole(),
            user.getMemo(),
            user.getCompanyId()
        );
        log.info("createUser savedUser = {}", newUser);
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