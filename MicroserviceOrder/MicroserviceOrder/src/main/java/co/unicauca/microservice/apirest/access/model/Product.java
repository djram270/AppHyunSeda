package co.unicauca.microservice.apirest.access.model;

import lombok.*;

import java.util.List;

/**
 * Clase que representa un producto.
 *
 * Esta clase modela un producto con un identificador, un nombre, una descripción, un precio,
 * una lista de categorías, un enlace de imagen y una cantidad disponible.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Product {

    /** Identificador del producto */
    private Long productId;

    /** Nombre del producto */
    private String name;

    /** Descripción del producto */
    private String description;

    /** Precio del producto */
    private double price;

    /** Lista de categorías del producto */
    private List<Category> categories;

    /** Enlace de imagen del producto */
    private String imageLink;

    /** Cantidad disponible del producto */
    private int amount;
}