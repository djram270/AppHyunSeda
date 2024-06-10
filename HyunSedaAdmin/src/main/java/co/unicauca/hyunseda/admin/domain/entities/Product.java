package co.unicauca.hyunseda.admin.domain.entities;

/**
 *
 * @author dizu8
 */
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
    private int amount;
    private List<Category> categories;
    private String imageLink;
}
