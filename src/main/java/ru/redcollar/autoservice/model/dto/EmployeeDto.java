package ru.redcollar.autoservice.model.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String surname;

}
