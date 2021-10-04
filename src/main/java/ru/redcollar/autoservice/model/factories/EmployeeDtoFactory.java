package ru.redcollar.autoservice.model.factories;

import org.springframework.stereotype.Component;
import ru.redcollar.autoservice.model.dto.EmployeeDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;

@Component
public class EmployeeDtoFactory {

    public EmployeeDto makeEmployeeDto(EmployeeEntity entity){

        return EmployeeDto.builder()
                .employeeID(entity.getEmployeeID())
                .surname(entity.getSurname())
                .name(entity.getName())
                .patronymic(entity.getPatronymic())
                .dateOfBirth(entity.getDateOfBirth())
                .phoneNumber(entity.getPhoneNumber())
                .position(entity.getPosition())
                .salary(entity.getSalary())
                .experience(entity.getExperience())
                .workingSchedule(entity.getWorkingSchedule())
                .seniorityAllowance(entity.getSeniorityAllowance())
                .build();
    }

}
