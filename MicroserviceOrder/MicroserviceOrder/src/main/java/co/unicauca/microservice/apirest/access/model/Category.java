package co.unicauca.microservice.apirest.access.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Clase que representa una categoría.
 *
 * Esta clase modela una categoría con un identificador y un nombre.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Category {

    /** Identificador de la categoría */
    private Long categoryId;

    /** Nombre de la categoría */
    private String name;
}