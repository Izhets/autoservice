package ru.redcollar.autoservice.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.redcollar.autoservice.model.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
