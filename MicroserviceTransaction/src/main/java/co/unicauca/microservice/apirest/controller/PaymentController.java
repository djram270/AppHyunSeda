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

@RestController
@RequestMapping("/Payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private iMicroserviceClient microserviceClient;

    @GetMapping("/get")
    public ResponseEntity<List<Transaction>> getTransactionHistory() {
        return ResponseEntity.ok(paymentService.getTransactionHistory());
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<List<Transaction>> getTransactionHistoryClient() {
        return ResponseEntity.ok(paymentService.getTransactionHistory());
    }

    @PostMapping("/post")
    public ResponseEntity<String> postTransaction(@RequestBody Transaction transaction) {
        if (microserviceClient.getClient(String.valueOf(transaction.getClientId())) == null)
        {
            return ResponseEntity.ok("The transaction can't be created because the client correspondent doesn't exist");
        }
        return ResponseEntity.ok(paymentService.postTransaction(transaction));
    }

}