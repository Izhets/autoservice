package ru.redcollar.autoservice.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcollar.autoservice.model.entities.UserEntity;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findById(Long userID);
    Stream<UserEntity> streamAllBy();

}
