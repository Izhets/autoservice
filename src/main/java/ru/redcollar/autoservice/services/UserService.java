package ru.redcollar.autoservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.redcollar.autoservice.model.dto.UserDto;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;
import ru.redcollar.autoservice.model.entities.UserEntity;
import ru.redcollar.autoservice.model.factories.UserDtoFactory;
import ru.redcollar.autoservice.repositories.UserRepository;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class UserService {

    private final UserDtoFactory userDtoFactory;
    private final UserRepository userRepository;

    public UserService(UserDtoFactory userDtoFactory, UserRepository userRepository) {
        this.userDtoFactory = userDtoFactory;
        this.userRepository = userRepository;
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

    public UserDto createUser(UserEntity user) {
//        UserEntity entity = UserEntity.builder()
//                .email(email)
//                .login(login)
//                .password(password)
//                .build();

            userRepository.save(user);
        return userDtoFactory.makeUserDto(user);
    }

//    public UserDto addUser(String email, String login, String password, String surname, String name, String patronymic,
//                           String dateOfBirth, Long phoneNumber,
//                           String position, Long salary, Long experience,
//                           String workingSchedule, Long seniorityAllowance) {
//
//        EmployeeEntity employeeEntity = EmployeeEntity.builder()
//                .surname(surname)
//                .name(name)
//                .patronymic(patronymic)
//                .dateOfBirth(parseDate(dateOfBirth))
//                .phoneNumber(phoneNumber)
//                .position(position)
//                .salary(salary)
//                .experience(experience)
//                .workingSchedule(workingSchedule)
//                .seniorityAllowance(seniorityAllowance)
//                .build();
//
//        UserEntity userEntity = UserEntity.builder()
//                .email(email)
//                .login(login)
//                .password(password)
//                .employeeEntity(employeeEntity)
//                .build();
//
//        UserEntity user = userRepository.save(userEntity);
//        return userDtoFactory.makeUserDto(user);
//    }

}
