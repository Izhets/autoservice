package ru.redcollar.autoservice.services;

import org.springframework.stereotype.Service;
import ru.redcollar.autoservice.exceptions.LockedAgeException;
import ru.redcollar.autoservice.exceptions.NotFoundEntityException;
import ru.redcollar.autoservice.model.dto.UserDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;
import ru.redcollar.autoservice.model.entities.UserEntity;
import ru.redcollar.autoservice.model.factories.UserDtoFactory;
import ru.redcollar.autoservice.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoFactory userDtoFactory;

    public UserService(UserRepository userRepository, UserDtoFactory userDtoFactory) {
        this.userRepository = userRepository;
        this.userDtoFactory = userDtoFactory;
    }

    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    public UserEntity createUser(UserDto userDto) {
        return userRepository.save(
                UserEntity.builder()
                        .id(userDto.getId())
                        .login(userDto.getLogin())
                        .password(userDto.getPassword())
                        .email(userDto.getEmail())
                        .build()
        );
    }

    public UserDto updateUser(Long id, UserDto userDto) throws LockedAgeException {

        Optional<UserEntity> optionalPerson = userRepository.findById(id);
        UserEntity user = optionalPerson.orElseThrow(() -> new NotFoundEntityException("пользователь", id));

        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());

        return userDtoFactory.makeUserDto(userRepository.save(user));
    }

    public void deleteUser(Long id) throws NotFoundEntityException {
        Optional<UserEntity> optionalPerson = userRepository.findById(id);
        optionalPerson.orElseThrow(() -> new NotFoundEntityException("пользователь", id));

        userRepository.deleteById(id);
    }

}
