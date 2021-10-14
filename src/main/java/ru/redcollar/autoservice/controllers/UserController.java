package ru.redcollar.autoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ru.redcollar.autoservice.model.entities.UserEntity;
import ru.redcollar.autoservice.repositories.UserRepository;
import ru.redcollar.autoservice.services.UserService;
import ru.redcollar.autoservice.model.dto.UserDto;

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

    @PostMapping("/user")
    public UserDto createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }



}
