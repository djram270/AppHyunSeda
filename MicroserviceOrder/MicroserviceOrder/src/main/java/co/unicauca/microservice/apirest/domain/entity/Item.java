package co.unicauca.microservice.apirest.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * Una entidad que representa un ítem en una orden.
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
@Data
@ToString
public class Item {
    /**
     * El identificador único del ítem.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    /**
     * El identificador del producto asociado a este ítem.
     */
    private Long productId;

    /**
     * La cantidad de este ítem en la orden.
     */
    private int amount;
}
