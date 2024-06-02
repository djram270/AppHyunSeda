package co.unicauca.microservice.apirest.domain.service.implementation;

import co.unicauca.microservice.apirest.domain.entity.MastercardValidator;
import co.unicauca.microservice.apirest.domain.entity.Transaction;
import co.unicauca.microservice.apirest.repository.iTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import co.unicauca.microservice.apirest.domain.service.iPaymentService;


@Service
public class PaymentService implements iPaymentService {

    @Autowired
    private iTransactionRepository transactionRepository;

    @Override
    public List<Transaction> getTransactionHistory() {
        return transactionRepository.findAll();
    }

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
