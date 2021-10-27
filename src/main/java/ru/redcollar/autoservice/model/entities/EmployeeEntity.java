package ru.redcollar.autoservice.model.entities;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Table("employee")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeEntity {

    @Id
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Date dateOfBirth;
    private String phoneNumber;
    private String post;
    private int salary;
    private int workExperience;
    private String duty;
    private String seniorityAllowance;
    private Long userID;
}
