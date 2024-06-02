package co.unicauca.microservice.apirest.repository;

import co.unicauca.microservice.apirest.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Repository interface for managing Category entities.
 */
@Repository
public interface iCategoryRepository extends JpaRepository<Category, Long> {
    /**
     * Finds a category by its name.
     *
     * @param name The name of the category to find.
     * @return The category with the specified name, or null if not found.
     */
    Category findByName(String name);
}
