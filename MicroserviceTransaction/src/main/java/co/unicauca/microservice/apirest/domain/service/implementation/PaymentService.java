package co.unicauca.microservice.apirest.domain.service.implementation;

import co.unicauca.microservice.apirest.domain.entity.MastercardValidator;
import co.unicauca.microservice.apirest.domain.entity.Transaction;
import co.unicauca.microservice.apirest.repository.iTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import co.unicauca.microservice.apirest.domain.service.iPaymentService;


/**
 * Servicio para gestionar las operaciones relacionadas con los pagos.
 */
@Service
public class PaymentService implements iPaymentService {

    /** Repositorio de transacciones. */
    @Autowired
    private iTransactionRepository transactionRepository;

    /**
     * Obtiene el historial de transacciones.
     * @return Lista de transacciones.
     */
    @Override
    public List<Transaction> getTransactionHistory() {
        return transactionRepository.findAll();
    }

    /**
     * Realiza una transacción.
     * @param transaction La transacción a ser realizada.
     * @return Mensaje indicando el resultado de la operación.
     */
    @Override
    public String postTransaction(Transaction transaction) {
        boolean isMastercardValid = MastercardValidator.validate(transaction.getCardNumber());

        if (!isMastercardValid) {
            return "Error: La tarjeta Mastercard no es válida";
        }

        // Si la tarjeta es válida, proceder con la transacción
        transactionRepository.save(transaction);
        return "Transaction was created successfully";
    }
}
