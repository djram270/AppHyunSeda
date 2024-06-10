package co.unicauca.microservice.apirest.auth.repository;

import co.unicauca.microservice.apirest.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByUsername (String username);
}
