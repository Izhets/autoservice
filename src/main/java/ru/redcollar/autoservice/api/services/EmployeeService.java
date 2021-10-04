package ru.redcollar.autoservice.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.redcollar.autoservice.exceptions.LockedAgeException;
import ru.redcollar.autoservice.model.dto.EmployeeDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;
import ru.redcollar.autoservice.model.factories.EmployeeDtoFactory;
import ru.redcollar.autoservice.model.repositories.EmployeeRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static ru.redcollar.autoservice.api.services.CheckService.checkAge;

@Service
public class EmployeeService {

    private EmployeeDtoFactory employeeDtoFactory;
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeDtoFactory employeeDtoFactory, EmployeeRepository employeeRepository) {
        this.employeeDtoFactory = employeeDtoFactory;
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private java.sql.Date parseDate(String date) {
        try {
            return new Date(DATE_FORMAT.parse(date).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private java.sql.Timestamp parseTimestamp(String timestamp) {
        try {
            return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }


    public EmployeeDto createEmployee(String surname, String name, String patronymic,
                                      String dateOfBirth, Long phoneNumber,
                                      String position, Long salary, Long experience,
                                      String workingSchedule, Long seniorityAllowance) throws LockedAgeException {

       checkAge(parseDate(dateOfBirth));

        EmployeeEntity entity = EmployeeEntity.builder()
                .surname(surname)
                .name(name)
                .patronymic(patronymic)
                .dateOfBirth(parseDate(dateOfBirth))
                .phoneNumber(phoneNumber)
                .position(position)
                .salary(salary)
                .experience(experience)
                .workingSchedule(workingSchedule)
                .seniorityAllowance(seniorityAllowance)
                .build();

        EmployeeEntity employee = employeeRepository.save(
                entity
        );

        return employeeDtoFactory.makeEmployeeDto(employee);
    }

}
