package co.unicauca.microservice.apirest.auth.repository;

import co.unicauca.microservice.apirest.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio para la entidad de usuario.
 *
 * Este repositorio proporciona métodos para realizar operaciones de base de datos relacionadas con la entidad de usuario.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca un usuario por nombre de usuario.
     *
     * @param username El nombre de usuario del usuario a buscar.
     * @return Un Optional que puede contener el usuario encontrado, o vacío si no se encuentra ninguno.
     */
    Optional<User> findByUsername(String username);
}
