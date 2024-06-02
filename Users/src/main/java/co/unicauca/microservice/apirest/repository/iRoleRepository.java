package co.unicauca.microservice.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.unicauca.microservice.apirest.domain.entity.Role;
/**
 * Repository interface for managing Role entities.
 */
@Repository
public interface iRoleRepository extends JpaRepository <Role, Long> {

}
