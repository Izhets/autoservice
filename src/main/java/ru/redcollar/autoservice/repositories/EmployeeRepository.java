package ru.redcollar.autoservice.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

}
