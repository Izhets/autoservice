package ru.redcollar.autoservice.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.redcollar.autoservice.model.dto.UserDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;
import ru.redcollar.autoservice.model.entities.UserEntity;
import ru.redcollar.autoservice.model.factories.EmployeeDtoFactory;
import ru.redcollar.autoservice.model.factories.UserDtoFactory;
import ru.redcollar.autoservice.model.repositories.EmployeeRepository;
import ru.redcollar.autoservice.model.repositories.UserRepository;

@Service
public class UserService {

    private UserDtoFactory userDtoFactory;
    private UserRepository userRepository;

    @Autowired
    public UserService(UserDtoFactory userDtoFactory, UserRepository userRepository) {
        this.userDtoFactory = userDtoFactory;
        this.userRepository = userRepository;
    }

    public UserDto createUser( String email, String login, String password) {
        UserEntity entity = UserEntity.builder()
                .email(email)
                .login(login)
                .password(password)
                .build();

        UserEntity user = userRepository.save(entity);
        return userDtoFactory.makeUserDto(user);
    }

}
