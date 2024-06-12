package co.unicauca.microservice.apirest.domain.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Clase que representa una transacción.
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
@Data
@ToString
public class Transaction {

    /** Identificador único de la transacción. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Identificador del cliente asociado a la transacción. */
    private int clientId;

    /** Monto de la transacción. */
    private double amount;

    /** Número de tarjeta asociado a la transacción. */
    private String cardNumber;
}