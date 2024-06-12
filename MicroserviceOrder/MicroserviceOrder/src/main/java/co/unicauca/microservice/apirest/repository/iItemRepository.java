package co.unicauca.microservice.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.unicauca.microservice.apirest.domain.entity.Item;

/**
 * Interfaz de repositorio para acceder a los datos de los elementos.
 */
public interface iItemRepository extends JpaRepository<Item, Long> {
}
