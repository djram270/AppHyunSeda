package co.unicauca.microservice.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.unicauca.microservice.apirest.domain.entity.Item;

public interface iItemRepository extends JpaRepository<Item, Long> {
}
