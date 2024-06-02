package co.unicauca.microservice.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.unicauca.microservice.apirest.domain.entity.Item;
/**
 * Repository interface for managing Item entities.
 */
public interface iItemRepository extends JpaRepository<Item, Long> {
}
