package co.unicauca.microservice.apirest.repository;

import co.unicauca.microservice.apirest.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface iTransactionRepository extends JpaRepository<Transaction, Long> {
}
