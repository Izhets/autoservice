package ru.redcollar.autoservice.services;

import org.springframework.stereotype.Service;
import ru.redcollar.autoservice.exceptions.LockedAgeException;
import ru.redcollar.autoservice.exceptions.NotFoundEntityException;
import ru.redcollar.autoservice.model.dto.EmployeeDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;
import ru.redcollar.autoservice.model.entities.UserEntity;
import ru.redcollar.autoservice.model.factories.EmployeeDtoFactory;
import ru.redcollar.autoservice.model.factories.UserDtoFactory;
import ru.redcollar.autoservice.repositories.EmployeeRepository;
import ru.redcollar.autoservice.repositories.UserRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static ru.redcollar.autoservice.validations.AgeValidator.checkAge;

@Service
public class EmployeeService {

    private final EmployeeDtoFactory employeeDtoFactory;
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final UserDtoFactory userDtoFactory;

    public EmployeeService(EmployeeDtoFactory employeeDtoFactory, EmployeeRepository employeeRepository, UserRepository userRepository, UserDtoFactory userDtoFactory) {
        this.employeeDtoFactory = employeeDtoFactory;
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
        this.userDtoFactory = userDtoFactory;
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

    public List<EmployeeEntity> getAllEmployees() {
        return (List<EmployeeEntity>) employeeRepository.findAll();
    }

    public EmployeeEntity getById(Long id) {
        Optional<EmployeeEntity> optionalPerson = employeeRepository.findById(id);
        EmployeeEntity employee = optionalPerson.orElseThrow(() -> new NotFoundEntityException("cотрудник", id));

        return employee;
    }

    public EmployeeDto createEmployee(UserEntity userEntity, EmployeeDto employeeDto) throws LockedAgeException {

        String dateOfBirth = String.valueOf(employeeDto.getDateOfBirth());
        checkAge(parseDate(dateOfBirth));

        EmployeeEntity employee = employeeRepository.save(
                EmployeeEntity.builder()
                        .userID(userEntity.getId())
                        .name(employeeDto.getName())
                        .surname(employeeDto.getSurname())
                        .patronymic(employeeDto.getPatronymic())
                        .dateOfBirth(parseDate(dateOfBirth))
                        .phoneNumber(employeeDto.getPhoneNumber())
                        .post(employeeDto.getPost())
                        .salary(employeeDto.getSalary())
                        .workExperience(employeeDto.getWorkExperience())
                        .duty(employeeDto.getDuty())
                        .seniorityAllowance(employeeDto.getSeniorityAllowance())
                        .build()
        );

        return employeeDtoFactory.makeEmployeeDto(employeeRepository.save(employee));
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) throws LockedAgeException {

        Optional<EmployeeEntity> optionalPerson = employeeRepository.findById(id);
        EmployeeEntity employee = optionalPerson.orElseThrow(() -> new NotFoundEntityException("cотрудник", id));

        String dateOfBirth = String.valueOf(employeeDto.getDateOfBirth());
        checkAge(parseDate(dateOfBirth));

        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setPatronymic(employeeDto.getPatronymic());
        employee.setDateOfBirth(parseDate(dateOfBirth));
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setPost(employeeDto.getPost());
        employee.setSalary(employeeDto.getSalary());
        employee.setWorkExperience(employeeDto.getWorkExperience());
        employee.setDuty(employeeDto.getDuty());
        employee.setSeniorityAllowance(employeeDto.getSeniorityAllowance());

        return employeeDtoFactory.makeEmployeeDto(employeeRepository.save(employee));
    }

    public void deleteEmployee(Long id) throws NotFoundEntityException {
        Optional<EmployeeEntity> optionalPerson = employeeRepository.findById(id);
        optionalPerson.orElseThrow(() -> new NotFoundEntityException("cотрудник", id));

        employeeRepository.deleteById(id);
    }
}
