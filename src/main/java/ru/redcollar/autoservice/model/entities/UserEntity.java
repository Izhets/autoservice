package ru.redcollar.autoservice.model.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "userList")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userID;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employee;

    private String login;
    private String password;
    private String email;

}
