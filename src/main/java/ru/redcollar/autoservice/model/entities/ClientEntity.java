package ru.redcollar.autoservice.model.entities;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Table("client")
@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
public class ClientEntity {

    @Id
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Date dateOfBirth;
    private String phoneNumber;
    private Long userID;
}

