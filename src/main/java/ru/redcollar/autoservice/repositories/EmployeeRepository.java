package ru.redcollar.autoservice.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;

import java.util.List;


public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
    //List<EmployeeEntity> findByUserId(Long userId);
}
