package ru.redcollar.autoservice.controllers;

import org.springframework.web.bind.annotation.*;
import ru.redcollar.autoservice.model.dto.ClientDto;
import ru.redcollar.autoservice.model.dto.UserDto;
import ru.redcollar.autoservice.model.entities.ClientEntity;
import ru.redcollar.autoservice.services.ClientService;
import ru.redcollar.autoservice.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ClientController {

    private final ClientService clientService;
    private final UserService userService;

    public ClientController(ClientService clientService, UserService userService) {
        this.clientService = clientService;
        this.userService = userService;
    }

    @GetMapping("/user/client")
    public List<ClientEntity> getAllClient() {
        return clientService.getAllClient();
    }

    @PostMapping("/user/client")
    public ClientDto addClient(@RequestPart UserDto userDto, @RequestPart ClientDto clientDto){
        return clientService.createClient(userService.createUser(userDto), clientDto);
    }

    @PutMapping("/user/client/{id}")
    public ClientDto updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto){
        return clientService.updateClient(id, clientDto);
    }

    @DeleteMapping("/user/client/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

}
