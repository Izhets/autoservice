package ru.redcollar.autoservice.model.factories;

import org.springframework.stereotype.Component;
import ru.redcollar.autoservice.model.dto.ClientDto;
import ru.redcollar.autoservice.model.entities.ClientEntity;

@Component
public class ClientDtoFactory {

    public ClientDto makeClientDto(ClientEntity entity){

        return ClientDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .patronymic(entity.getPatronymic())
                .dateOfBirth(entity.getDateOfBirth())
                .phoneNumber(entity.getPhoneNumber())
                .userID(entity.getUserID())
                .build();
    }

}
