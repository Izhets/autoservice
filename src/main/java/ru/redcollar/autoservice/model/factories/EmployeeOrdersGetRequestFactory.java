package ru.redcollar.autoservice.model.factories;

import ru.redcollar.autoservice.model.dto.EmployeeOrdersGetRequest;
import ru.redcollar.autoservice.model.dto.OrderListDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EmployeeOrdersGetRequestFactory {

    public EmployeeOrdersGetRequest makeEmployeeOrdersGetRequestFactory(EmployeeEntity entity, List<OrderListDto> orderListDto){

        return EmployeeOrdersGetRequest.builder()
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
                .ordersList(orderListDto)
                .build();
    }
}

