package ru.redcollar.autoservice.model.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table("user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserEntity {

    @Id
    private Long id;
    private String login;
    private String password;
    private String email;


    @MappedCollection(idColumn = "user_id")
    private EmployeeEntity employee;
}
