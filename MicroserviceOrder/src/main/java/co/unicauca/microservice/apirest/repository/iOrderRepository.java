package co.unicauca.microservice.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.unicauca.microservice.apirest.domain.entity.Order;

import java.util.List;
/**
 * Repository interface for managing Order entities.
 */
public interface iOrderRepository extends JpaRepository<Order, Long> {
    /**
     * Finds orders by their state specified as a string.
     *
     * @param strState The state of the orders to find.
     * @return A list of orders with the specified state.
     */
    List<Order> findByStrState(String strState);
}

