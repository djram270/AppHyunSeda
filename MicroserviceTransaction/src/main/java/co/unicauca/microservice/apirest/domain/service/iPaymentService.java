package co.unicauca.microservice.apirest.domain.service;
import co.unicauca.microservice.apirest.domain.entity.Transaction;

import java.util.List;

public interface iPaymentService {
    List<Transaction> getTransactionHistory();

    String postTransaction(Transaction transaction);
}

