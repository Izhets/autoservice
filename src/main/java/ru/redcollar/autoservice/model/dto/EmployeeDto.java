package ru.redcollar.autoservice.model.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    @NonNull
    private Long id;
    private String surname;
    private Long userID;

}
