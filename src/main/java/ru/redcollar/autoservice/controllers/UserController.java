package ru.redcollar.autoservice.controllers;

import org.springframework.web.bind.annotation.*;

import ru.redcollar.autoservice.model.dto.UserDto;
import ru.redcollar.autoservice.model.entities.UserEntity;
import ru.redcollar.autoservice.repositories.UserRepository;
import ru.redcollar.autoservice.services.UserService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<UserEntity> getAllStudents() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @PutMapping("/user/{id}")
    public UserDto updateEmployee(@PathVariable Long id, @RequestBody UserDto userDto){
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/user/{id}")
    public void deleteEmployee(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
