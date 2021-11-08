package ru.redcollar.autoservice.model.factories;

import org.springframework.stereotype.Component;
import ru.redcollar.autoservice.model.dto.ClientCreateRequest;
import ru.redcollar.autoservice.model.dto.ClientDto;
import ru.redcollar.autoservice.model.entities.ClientEntity;
import ru.redcollar.autoservice.model.entities.UserEntity;

@Component
public class ClientCreateRequestFactory {

    public ClientCreateRequest makeClientDto(ClientEntity entity, UserEntity user){

        return ClientCreateRequest.builder()
                .id(entity.getId())
                .login(user.getLogin())
                .email(user.getEmail())
                .password(user.getPassword())
                .name(entity.getName())
                .surname(entity.getSurname())
                .patronymic(entity.getPatronymic())
                .dateOfBirth(entity.getDateOfBirth())
                .phoneNumber(entity.getPhoneNumber())
                .userID(user.getId())
                .build();
    }

}
