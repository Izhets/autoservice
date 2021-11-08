package ru.redcollar.autoservice.controllers;

import org.springframework.web.bind.annotation.*;

import ru.redcollar.autoservice.model.dto.UserDto;
import ru.redcollar.autoservice.model.entities.UserEntity;
import ru.redcollar.autoservice.repositories.UserRepository;
import ru.redcollar.autoservice.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/profiles/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getAllStudents() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserDto updateEmployee(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
