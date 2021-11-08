package ru.redcollar.autoservice.model.dto;
import lombok.*;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientCreateRequest {

    //user part
    private String login;
    private String password;
    private String email;

    //client part
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Date dateOfBirth;
    private String phoneNumber;
    private Long userID;

}
