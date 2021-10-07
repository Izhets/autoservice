package ru.redcollar.autoservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.redcollar.autoservice.exceptions.LockedAgeException;
import ru.redcollar.autoservice.model.dto.EmployeeDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;
import ru.redcollar.autoservice.model.factories.EmployeeDtoFactory;
import ru.redcollar.autoservice.repositories.EmployeeRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static ru.redcollar.autoservice.services.CheckService.checkAge;

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
        return (List<EmployeeEntity>) employeeRepository.findAll();
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


    public EmployeeDto createEmployee(EmployeeDto e) throws LockedAgeException {

        EmployeeEntity entity = EmployeeEntity.builder()
                .surname(e.getSurname())
                .build();

        return employeeDtoFactory.makeEmployeeDto(employeeRepository.save(entity));
    }

    public EmployeeEntity saveEmployee(EmployeeEntity entity){
        return employeeRepository.save(entity);
    }

}
