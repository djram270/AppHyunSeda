package co.unicauca.microservice.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.unicauca.microservice.apirest.domain.entity.Order;

import java.util.List;

/**
 * Interfaz de repositorio para acceder a los datos de las órdenes.
 */
public interface iOrderRepository extends JpaRepository<Order, Long> {

    /**
     * Busca todas las órdenes con un estado específico.
     *
     * @param strState El estado de las órdenes a buscar.
     * @return Una lista de órdenes que tienen el estado especificado.
     */
    List<Order> findByStrState(String strState);
}
