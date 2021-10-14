package ru.redcollar.autoservice.model.dto;

import lombok.*;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    @NonNull
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Date dateOfBirth;
    private String phoneNumber;
    private Long userID;

}
