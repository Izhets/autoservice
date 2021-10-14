package ru.redcollar.autoservice.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.redcollar.autoservice.model.entities.ClientEntity;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
}
