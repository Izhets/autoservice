package ru.redcollar.autoservice.model.factories;

import org.springframework.stereotype.Component;
import ru.redcollar.autoservice.model.dto.EmployeeDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;

@Component
public class EmployeeDtoFactory {

    public EmployeeDto makeEmployeeDto(EmployeeEntity entity){

        return EmployeeDto.builder()
                .id(entity.getId())
                .surname(entity.getSurname())
                .userID(entity.getUserID())
                .build();
    }

    public EmployeeEntity makeEmployee(EmployeeDto employee){
        return EmployeeEntity.builder()
                .surname(employee.getSurname())
                .userID(employee.getUserID())
                .build();
    }

}
