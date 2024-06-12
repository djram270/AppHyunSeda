package co.unicauca.microservice.apirest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
/**
 * Clase para representar un producto.
 *
 * Esta clase define la estructura de un producto en la aplicación.
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
@Data
@ToString
public class Product {

    /** El ID del producto. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    /** Las categorías a las que pertenece el producto. */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "categories",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "productId"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "categoryId"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "category_id"})
    )
    private List<Category> categories;

    /** El nombre del producto. */
    @Basic
    private String name;

    /** La descripción del producto. */
    private String description;

    /** El enlace a la imagen del producto. */
    private String imageLink;

    /** La cantidad disponible del producto. */
    private int amount;

    /** El precio del producto. */
    private double price;
}