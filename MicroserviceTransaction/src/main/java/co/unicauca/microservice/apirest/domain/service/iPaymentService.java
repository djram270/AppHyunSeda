package co.unicauca.microservice.apirest.domain.service;
import co.unicauca.microservice.apirest.domain.entity.Transaction;

import java.util.List;

/**
 * Interfaz para definir los servicios relacionados con los pagos.
 */
public interface iPaymentService {

    /**
     * Obtiene el historial de transacciones.
     * @return Lista de transacciones.
     */
    List<Transaction> getTransactionHistory();

    /**
     * Realiza una transacción.
     * @param transaction La transacción a ser realizada.
     * @return Mensaje indicando el resultado de la operación.
     */
    String postTransaction(Transaction transaction);
}