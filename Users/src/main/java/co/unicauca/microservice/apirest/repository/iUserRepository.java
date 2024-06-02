package co.unicauca.microservice.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.unicauca.microservice.apirest.domain.entity.User;
import co.unicauca.microservice.apirest.domain.entity.Role;
import java.util.List;
/**
 * Repository interface for managing User entities.
 */
@Repository
public interface iUserRepository extends JpaRepository <User, Long> {
    /**
     * Finds the roles associated with a user by username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return A list of roles associated with the user.
     */
    @Query("SELECT u.roles FROM User u WHERE u.username = :username AND u.password = :password")
    List<Role> findRolesByUsernameAndPassword(String username, String password);
    /**
     * Finds the user ID by username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The ID of the user, or null if not found.
     */
    @Query("SELECT u.userId FROM User u WHERE u.username = :username AND u.password = :password")
    Long findUserIdByUsernameAndPassword(String username, String password);
}