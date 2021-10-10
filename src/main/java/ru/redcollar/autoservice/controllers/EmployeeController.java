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

    @GetMapping("/user/employee")
    public List<EmployeeEntity> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/user/employee")
    public EmployeeDto addEmployee(@RequestPart UserDto userDto, @RequestPart EmployeeDto employeeDto){
        return employeeService.createEmployee(userDto, employeeDto);
    }

    @PutMapping("/user/employee/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(id, employeeDto);
    }

    @DeleteMapping("/user/employee/{id}")
    public void deleteEmployee(@PathVariable Long id){
       employeeService.deleteEmployee(id);
    }

}
