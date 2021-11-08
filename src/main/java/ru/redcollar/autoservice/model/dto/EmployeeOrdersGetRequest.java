package ru.redcollar.autoservice.model.dto;

import lombok.*;
import ru.redcollar.autoservicecommonlib.model.dto.OrderListDto;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeOrdersGetRequest {

    //order part
    private List<OrderListDto> ordersList;


    //employee part
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
