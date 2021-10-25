package ru.redcollar.autoservice.model.factories;

import org.springframework.stereotype.Component;
import ru.redcollar.autoservice.model.dto.EmployeeDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;

@Component
public class EmployeeDtoFactory {

    public EmployeeDto makeEmployeeDto(EmployeeEntity entity){

        return EmployeeDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .patronymic(entity.getPatronymic())
                .dateOfBirth(entity.getDateOfBirth())
                .phoneNumber(entity.getPhoneNumber())
                .post(entity.getPost())
                .salary(entity.getSalary())
                .workExperience(entity.getWorkExperience())
                .duty(entity.getDuty())
                .seniorityAllowance(entity.getSeniorityAllowance())
                .userID(entity.getUserID())
                .build();
    }
}

//mappedstruct//