package co.unicauca.microservice.apirest.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
@Data
@ToString
public class Product {

    //Para fijar la id de la tabla y generar la id automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    /**
     * The list of categories associated with this product.
     */
    @ManyToMany (fetch = FetchType.EAGER, cascade =  CascadeType.MERGE)
    @JoinTable
            (
                    name = "categories",
                    joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "productId"),
                    inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName =  "categoryId"),
                    uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "category_id"})
            )
    private List<Category> categories; //category[] Maybe

    @Basic
    private String name;

    private String description;

    private String imageLink;

    private int amount;

    private double price;
}
