package ru.redcollar.autoservice.api.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.redcollar.autoservice.api.services.EmployeeService;
import ru.redcollar.autoservice.exceptions.LockedAgeException;
import ru.redcollar.autoservice.model.dto.EmployeeDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Transactional
@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Tag(name = "PostReq Employees", description = "Post request to employee entity")
    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestParam String surname, @RequestParam String name, @RequestParam String patronymic, @RequestParam Long phoneNumber, @RequestParam String position,
                                      @RequestParam (required = false) String dateOfBirth,
                                      @RequestParam Long salary, @RequestParam Long experience, @RequestParam String workingSchedule,
                                      @RequestParam Long seniorityAllowance) throws LockedAgeException {

        return employeeService.createEmployee(surname, name, patronymic, dateOfBirth, phoneNumber, position, salary, experience, workingSchedule, seniorityAllowance);
    }

    @Tag(name = "GetReq all employees", description = "Get all employee entity")
    @GetMapping("/employees")
    public List<EmployeeEntity> findAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
