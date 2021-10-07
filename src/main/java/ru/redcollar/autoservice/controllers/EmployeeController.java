package ru.redcollar.autoservice.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;
import ru.redcollar.autoservice.model.entities.UserEntity;
import ru.redcollar.autoservice.repositories.EmployeeRepository;
import ru.redcollar.autoservice.repositories.UserRepository;
import ru.redcollar.autoservice.services.EmployeeService;
import ru.redcollar.autoservice.exceptions.LockedAgeException;
import ru.redcollar.autoservice.model.dto.EmployeeDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/contacts")
    public List<EmployeeEntity> getAllContacts(){
        return (List<EmployeeEntity>) employeeRepository.findAll();
    }
//
//    @PostMapping("/users/{userId}/employee")
//    public EmployeeEntity addContact(@PathVariable Long userId,
//                              @Valid @RequestBody EmployeeEntity employee) {
//        return userRepository.findById(userId)
//                .map(user -> {
//                    employee.setUser(user);
//                    return employeeRepository.save(employee);
//                }).orElseThrow(() -> new NotFoundException("Student not found!"));
//    }



//    @Tag(name = "PostReq Employees", description = "Post request to employee entity")
//    @PostMapping("/employees")
//    public EmployeeDto createEmployee(@RequestBody EmployeeDto employee) throws LockedAgeException {
//
//        return employeeService.createEmployee(employee);
//    }
//
//    @PostMapping("/students")
//    public EmployeeEntity createStudent(@Valid @RequestBody EmployeeEntity employee) {
//        return employeeRepository.save(employee);
//    }
//
//    @PostMapping("/user-create")
//    public EmployeeEntity createUser(@RequestBody EmployeeDto employee){
//
//        EmployeeEntity entity = EmployeeEntity.builder()
//                .surname(employee.getSurname())
//                .build();
//
//        EmployeeEntity employeeo = employeeRepository.save(entity);
//
//       return employeeRepository.save(employeeo);
//    }
//

    @PostMapping("/users/{userId}/employee")
    public EmployeeEntity addContact(@PathVariable Long userId,
                              @Valid @RequestBody EmployeeEntity employee) {
        return userRepository.findById(userId)
                .map(UserEntity -> {
                     employee.setUser_id(UserEntity.getId());
                    return employeeRepository.save(employee);
                }).orElseThrow(() -> new NotFoundException("Employee not found!"));
    }
}
