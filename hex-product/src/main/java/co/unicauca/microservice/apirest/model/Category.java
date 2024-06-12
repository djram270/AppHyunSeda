package co.unicauca.microservice.apirest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Clase para representar una categoría.
 *
 * Esta clase define la estructura de una categoría en la aplicación.
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
@Data
@ToString
public class Category {

    /** El ID de la categoría. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    /** El nombre de la categoría. */
    private String name;
}