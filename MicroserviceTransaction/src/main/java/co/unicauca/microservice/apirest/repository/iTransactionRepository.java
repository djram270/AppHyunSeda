package co.unicauca.microservice.apirest.repository;

import co.unicauca.microservice.apirest.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Interfaz para el repositorio de transacciones.
 * Extiende JpaRepository para obtener funcionalidades CRUD para la entidad Transaction.
 */
public interface iTransactionRepository extends JpaRepository<Transaction, Long> {
}
