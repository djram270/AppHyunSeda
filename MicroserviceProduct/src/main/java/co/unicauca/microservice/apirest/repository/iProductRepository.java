package co.unicauca.microservice.apirest.repository;

import co.unicauca.microservice.apirest.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Repository interface for managing Product entities.
 */
@Repository
public interface iProductRepository extends JpaRepository<Product, Long> {
    /**
     * Finds products by name.
     *
     * @param name The name of the product(s) to find.
     * @return A list of products matching the specified name.
     */
    List<Product> findByName(String name);
    /**
     * Finds products by category name.
     *
     * @param categoryName The name of the category to filter products by.
     * @return A list of products associated with the specified category.
     */
    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.name = :categoryName")
    List<Product> findByCategory(String categoryName);
}
