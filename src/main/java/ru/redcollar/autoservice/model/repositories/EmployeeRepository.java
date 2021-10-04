package ru.redcollar.autoservice.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findBySurname(String surname);

    List<EmployeeEntity> findByName(String name);

    Optional<EmployeeEntity> findByPatronymic(String patronymic);

    Optional<EmployeeEntity> findByDateOfBirth(Timestamp dateOfBirth);

    Optional<EmployeeEntity> findByPhoneNumber(Long phoneNumber);

    Optional<EmployeeEntity> findByPosition(String position);

    Optional<EmployeeEntity> findBySalary(Long salary);

    Optional<EmployeeEntity> findByExperience(Long experience);

    Optional<EmployeeEntity> findByWorkingSchedule(String workingSchedule);

    Optional<EmployeeEntity> findBySeniorityAllowance(Long seniorityAllowance);

    Stream<EmployeeEntity> streamAllBy();

}
