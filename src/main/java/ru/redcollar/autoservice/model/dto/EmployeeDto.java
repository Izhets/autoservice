package ru.redcollar.autoservice.model.dto;


import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    @NonNull
    private Long employeeID;

    @NonNull
    private String surname;

    @NonNull
    private String name;

    @NonNull
    private String patronymic;

    private Date dateOfBirth;

    private Long phoneNumber;

    private String position;

    private Long salary;

    private Long experience;

    private String workingSchedule;

    private Long seniorityAllowance;
}
