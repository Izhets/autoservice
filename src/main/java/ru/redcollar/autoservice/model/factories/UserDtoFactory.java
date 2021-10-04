package ru.redcollar.autoservice.model.factories;

import org.springframework.stereotype.Component;
import ru.redcollar.autoservice.model.dto.UserDto;
import ru.redcollar.autoservice.model.entities.UserEntity;

@Component
public class UserDtoFactory {

    public UserDto makeUserDto(UserEntity entity) {

        return UserDto.builder()
                .userID(entity.getUserID())
                .login(entity.getLogin())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .build();
    }
}
