package ru.redcollar.autoservice.model.dto;


import lombok.*;

@Data
@Builder
public class EmployeeDto {

    private Long id;
    private String surname;

}
