package ru.redcollar.autoservice.services;

import org.springframework.stereotype.Service;
import ru.redcollar.autoservice.exceptions.LockedAgeException;
import ru.redcollar.autoservice.exceptions.NotFoundEntityException;
import ru.redcollar.autoservice.model.dto.ClientDto;
import ru.redcollar.autoservice.model.dto.EmployeeDto;
import ru.redcollar.autoservice.model.dto.OrderListDto;
import ru.redcollar.autoservice.model.entities.ClientEntity;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;
import ru.redcollar.autoservice.model.entities.UserEntity;
import ru.redcollar.autoservice.model.factories.ClientDtoFactory;
import ru.redcollar.autoservice.model.factories.EmployeeDtoFactory;
import ru.redcollar.autoservice.repositories.ClientRepository;
import ru.redcollar.autoservice.repositories.EmployeeRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ru.redcollar.autoservice.validations.AgeValidator.checkAge;

@Service
public class ClientService {

    private final WebClientService webClientService;

    private final ClientRepository clientRepository;
    private final ClientDtoFactory clientDtoFactory;
    private final EmployeeService employeeService;
    private final EmployeeDtoFactory employeeDtoFactory;
    private final EmployeeRepository employeeRepository;

    public ClientService(WebClientService webClientService, ClientRepository clientRepository, ClientDtoFactory clientDtoFactory, EmployeeService employeeService, EmployeeDtoFactory employeeDtoFactory, EmployeeRepository employeeRepository) {
        this.webClientService = webClientService;
        this.clientRepository = clientRepository;
        this.clientDtoFactory = clientDtoFactory;
        this.employeeService = employeeService;
        this.employeeDtoFactory = employeeDtoFactory;
        this.employeeRepository = employeeRepository;
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

    private java.sql.Timestamp parseTimestamp(String timestamp) {
        try {
            return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<ClientEntity> getAllClient() {
        return (List<ClientEntity>) clientRepository.findAll();
    }

    public ClientEntity getById(Long id) {
        Optional<ClientEntity> optionalPerson = clientRepository.findById(id);
        ClientEntity client = optionalPerson.orElseThrow(() -> new NotFoundEntityException("cотрудник", id));

        return client;
    }

    public ClientDto createClient(UserEntity userEntity, ClientDto clientDto) throws LockedAgeException {

        String dateOfBirth = String.valueOf(clientDto.getDateOfBirth());
        checkAge(parseDate(dateOfBirth));

        ClientEntity client = clientRepository.save(
                ClientEntity.builder()
                        .userID(userEntity.getId())
                        .name(clientDto.getName())
                        .surname(clientDto.getSurname())
                        .patronymic(clientDto.getPatronymic())
                        .dateOfBirth(parseDate(dateOfBirth))
                        .phoneNumber(clientDto.getPhoneNumber())
                        .build()
        );

        return clientDtoFactory.makeClientDto(clientRepository.save(client));
    }

    public ClientDto updateClient(Long id, ClientDto clientDto) throws LockedAgeException {

        Optional<ClientEntity> optionalPerson = clientRepository.findById(id);
        ClientEntity client = optionalPerson.orElseThrow(() -> new NotFoundEntityException("клиент", id));

        String dateOfBirth = String.valueOf(clientDto.getDateOfBirth());
        checkAge(parseDate(dateOfBirth));

        client.setName(clientDto.getName());
        client.setSurname(clientDto.getSurname());
        client.setPatronymic(clientDto.getPatronymic());
        client.setDateOfBirth(parseDate(dateOfBirth));
        client.setPhoneNumber(clientDto.getPhoneNumber());

        return clientDtoFactory.makeClientDto(clientRepository.save(client));
    }

    public void deleteClient(Long id) throws NotFoundEntityException {
        Optional<ClientEntity> optionalPerson = clientRepository.findById(id);
        optionalPerson.orElseThrow(() -> new NotFoundEntityException("клиент", id));

        clientRepository.deleteById(id);
    }

    public String getNameOrderEmployee(Long id){
        Optional<EmployeeEntity> optionalPerson = employeeRepository.findById(id);
        EmployeeEntity employee = optionalPerson.orElseThrow(() -> new NotFoundEntityException("клиент", id));

        List<OrderListDto> orderListDtoList = webClientService.getOrdersList();

        for (OrderListDto orders : orderListDtoList){
            if (Objects.equals(orders.getClientId(), id)){
                employee = employeeService.getById(id);
            }
        }

        return employee.getName();
    }

}
