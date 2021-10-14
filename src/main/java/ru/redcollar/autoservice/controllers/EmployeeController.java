package ru.redcollar.autoservice.controllers;

import org.springframework.web.bind.annotation.*;
import ru.redcollar.autoservice.model.dto.EmployeeDto;
import ru.redcollar.autoservice.model.dto.UserDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;
import ru.redcollar.autoservice.services.EmployeeService;
import ru.redcollar.autoservice.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final UserService userService;

    public EmployeeController(EmployeeService employeeService, UserService userService) {
        this.employeeService = employeeService;
        this.userService = userService;
    }

    @GetMapping("/user/employee")
    public List<EmployeeEntity> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

//Кривой метод
//    @PostMapping("/user/employee")
//    public EmployeeDto addEmployee(@RequestPart UserDto userDto, @RequestPart EmployeeDto employeeDto){
//        return employeeService.createEmployee(userDto, employeeDto);
//    }

    @PostMapping("/user/employee")
    public EmployeeDto addEmployee(@RequestPart UserDto userDto, @RequestPart EmployeeDto employeeDto){
        return employeeService.createEmployee(userService.createUser(userDto), employeeDto);
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
