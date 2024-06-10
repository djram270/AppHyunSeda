package co.unicauca.microservice.apirest.access.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Product {
    private Long productId;
    private String name;
    private String description;
    private double price;
    private List<Category> categories;
    private String imageLink;
    private int amount;
}