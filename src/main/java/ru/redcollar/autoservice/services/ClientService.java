package ru.redcollar.autoservice.services;

import org.springframework.stereotype.Service;
import ru.redcollar.autoservice.exceptions.LockedAgeException;
import ru.redcollar.autoservice.exceptions.NotFoundEntityException;
import ru.redcollar.autoservice.model.dto.ClientCreateRequest;
import ru.redcollar.autoservice.model.dto.ClientDto;
import ru.redcollar.autoservice.model.entities.ClientEntity;
import ru.redcollar.autoservice.model.entities.EmployeeEntity;
import ru.redcollar.autoservice.model.entities.UserEntity;
import ru.redcollar.autoservice.model.factories.ClientCreateRequestFactory;
import ru.redcollar.autoservice.model.factories.ClientDtoFactory;
import ru.redcollar.autoservice.model.factories.EmployeeDtoFactory;
import ru.redcollar.autoservice.repositories.ClientRepository;
import ru.redcollar.autoservice.repositories.EmployeeRepository;
import ru.redcollar.autoservice.repositories.UserRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static ru.redcollar.autoservice.validations.AgeValidator.checkAge;

@Service
public class ClientService {

    private final WebClientService webClientService;

    private final ClientRepository clientRepository;
    private final ClientDtoFactory clientDtoFactory;
    private final UserRepository userRepository;
    private final EmployeeService employeeService;
    private final EmployeeDtoFactory employeeDtoFactory;
    private final EmployeeRepository employeeRepository;
    private final ClientCreateRequestFactory clientCreateRequestFactory;

    public ClientService(WebClientService webClientService, ClientRepository clientRepository, ClientDtoFactory clientDtoFactory, UserRepository userRepository, EmployeeService employeeService, EmployeeDtoFactory employeeDtoFactory, EmployeeRepository employeeRepository, ClientCreateRequestFactory clientCreateRequestFactory) {
        this.webClientService = webClientService;
        this.clientRepository = clientRepository;
        this.clientDtoFactory = clientDtoFactory;
        this.userRepository = userRepository;
        this.employeeService = employeeService;
        this.employeeDtoFactory = employeeDtoFactory;
        this.employeeRepository = employeeRepository;
        this.clientCreateRequestFactory = clientCreateRequestFactory;
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

        public ClientCreateRequest createClient(ClientCreateRequest clientCreateDto) throws LockedAgeException {

        String dateOfBirth = String.valueOf(clientCreateDto.getDateOfBirth());
        checkAge(parseDate(dateOfBirth));

        UserEntity user = userRepository.save(
                UserEntity.builder()
                        .login(clientCreateDto.getLogin())
                        .password(clientCreateDto.getPassword())
                        .email(clientCreateDto.getEmail())
                        .build()
        );

        ClientEntity client = clientRepository.save(
                ClientEntity.builder()
                        .userID(user.getId())
                        .name(clientCreateDto.getName())
                        .surname(clientCreateDto.getSurname())
                        .patronymic(clientCreateDto.getPatronymic())
                        .dateOfBirth(parseDate(dateOfBirth))
                        .phoneNumber(clientCreateDto.getPhoneNumber())
                        .build()
        );

        return clientCreateRequestFactory.makeClientDto(client, user);
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

}
