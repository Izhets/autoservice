package ru.redcollar.autoservice.controllers;

import org.springframework.web.bind.annotation.*;
import ru.redcollar.autoservice.model.dto.EmployeeDto;
import ru.redcollar.autoservice.model.dto.EmployeeOrdersGetRequest;
import ru.redcollar.autoservice.model.dto.UserDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;
import ru.redcollar.autoservice.services.EmployeeService;
import ru.redcollar.autoservice.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/profiles/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final UserService userService;

    public EmployeeController(EmployeeService employeeService, UserService userService) {
        this.employeeService = employeeService;
        this.userService = userService;
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDto addEmployee(@RequestPart UserDto userDto, @RequestPart EmployeeDto employeeDto){
        return employeeService.createEmployee(userService.createUser(userDto), employeeDto);
    }

//Bean Scopes

    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(id, employeeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
       employeeService.deleteEmployee(id);
    }

    @GetMapping("/{id}/orders")
    public EmployeeOrdersGetRequest getNameOrderEmployee(@PathVariable Long id){
        return employeeService.getEmployeeOrders(id);
    }

}
