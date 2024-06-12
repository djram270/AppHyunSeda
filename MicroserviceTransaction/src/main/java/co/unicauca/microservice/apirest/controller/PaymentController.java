package co.unicauca.microservice.apirest.controller;

import co.unicauca.microservice.apirest.access.microservice.iMicroserviceClient;
import co.unicauca.microservice.apirest.access.microservice.implementation.MicroserviceClient;
import co.unicauca.microservice.apirest.access.model.Client;
import co.unicauca.microservice.apirest.domain.entity.Transaction;
import co.unicauca.microservice.apirest.domain.service.implementation.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
/**
 * Esta clase actúa como un controlador REST para gestionar las operaciones relacionadas con los pagos.
 * Proporciona endpoints para obtener historial de transacciones y crear nuevas transacciones.
 */
@RestController
@RequestMapping("/Payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private iMicroserviceClient microserviceClient;
    /**
     * Obtiene el historial de transacciones.
     * @return ResponseEntity con una lista de objetos {@link Transaction}.
     */
    @GetMapping("/get")
    public ResponseEntity<List<Transaction>> getTransactionHistory() {
        return ResponseEntity.ok(paymentService.getTransactionHistory());
    }
    /**
     * Obtiene el historial de transacciones de un cliente específico.
     * @param id El ID del cliente del cual se desea obtener el historial de transacciones.
     * @return ResponseEntity con una lista de objetos {@link Transaction}.
     */
    @GetMapping("/get/id/{id}")
    public ResponseEntity<List<Transaction>> getTransactionHistoryClient() {
        return ResponseEntity.ok(paymentService.getTransactionHistory());
    }
    /**
     * Crea una nueva transacción.
     * Verifica si el cliente correspondiente existe antes de crear la transacción.
     * @param transaction La transacción a ser creada.
     * @return ResponseEntity con un mensaje de confirmación.
     */
    @PostMapping("/post")
    public ResponseEntity<String> postTransaction(@RequestBody Transaction transaction) {
        if (microserviceClient.getClient(String.valueOf(transaction.getClientId())) == null)
        {
            return ResponseEntity.ok("The transaction can't be created because the client correspondent doesn't exist");
        }
        return ResponseEntity.ok(paymentService.postTransaction(transaction));
    }

}