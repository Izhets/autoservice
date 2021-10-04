package ru.redcollar.autoservice.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.redcollar.autoservice.api.services.UserService;
import ru.redcollar.autoservice.model.dto.UserDto;

import javax.transaction.Transactional;

@Transactional
@RestController
@RequestMapping("/api")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/users")
    public UserDto createUser(@RequestParam String login, @RequestParam String password, @RequestParam String email) {
        return userService.createUser(login, password, email);
    }

}
