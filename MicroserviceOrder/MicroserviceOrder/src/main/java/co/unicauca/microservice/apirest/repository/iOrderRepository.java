package co.unicauca.microservice.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.unicauca.microservice.apirest.domain.entity.Order;

import java.util.List;

public interface iOrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStrState(String strState);
}

