package ru.redcollar.autoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.webjars.NotFoundException;
import ru.redcollar.autoservice.model.entities.UserEntity;
import ru.redcollar.autoservice.repositories.UserRepository;
import ru.redcollar.autoservice.services.UserService;
import ru.redcollar.autoservice.model.dto.UserDto;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  UserService userService;

    @GetMapping("/users")
    public List<UserEntity> getAllStudents() {

        return (List<UserEntity>) userRepository.findAll();
    }

    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

//    @PutMapping("/students/{id}")
//    public UserEntity updatec(@PathVariable Long id,
//                              @Valid @RequestBody UserEntity userUpdated) {
//        return userRepository.findById(id)
//                .map(user -> {
//                    user.setLogin(userUpdated.getLogin());
//                    user.setPassword(userUpdated.getPassword());
//                    user.setEmail(userUpdated.getEmail());
//                    return userRepository.save(user);
//                }).orElseThrow(() -> new NotFoundException("Student not found with id " + id));
//    }

}
