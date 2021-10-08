package ru.redcollar.autoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.redcollar.autoservice.model.dto.EmployeeDto;
import ru.redcollar.autoservice.model.dto.UserDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;
import ru.redcollar.autoservice.repositories.EmployeeRepository;
import ru.redcollar.autoservice.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/contacts")
    public List<EmployeeEntity> getAllContacts() {
        return (List<EmployeeEntity>) employeeRepository.findAll();
    }

//    @PostMapping("/users/employee")
//    public EmployeeDto addEmployee(@RequestParam String login, String password, String email, String surname) {
//        return employeeService.createEmployee(login, password, email, surname);
//    }

    @PostMapping("/users/employee")
    public EmployeeDto addEmployee(@RequestPart UserDto userDto, @RequestPart EmployeeDto employeeDto) {
        return employeeService.createEmployee(userDto, employeeDto);
    }

}
