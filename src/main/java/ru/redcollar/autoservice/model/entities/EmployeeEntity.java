package ru.redcollar.autoservice.model.entities;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("employee")
@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
public class EmployeeEntity {

    @Id
    private Long id;
    private String surname;
    private Long userID;

}
