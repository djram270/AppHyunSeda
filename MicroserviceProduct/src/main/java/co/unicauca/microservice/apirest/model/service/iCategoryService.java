package co.unicauca.microservice.apirest.model.service;

import co.unicauca.microservice.apirest.model.entity.Category;
import co.unicauca.microservice.apirest.model.entity.Product;

import java.util.List;
/**
 * Service interface for managing Category entities.
 */
public interface iCategoryService {

    /**
     * Retrieves all categories from the database.
     *
     * @return A list of all categories.
     */
    List<Category> getCategories();

    /**
     * Retrieves a specific category by its ID.
     *
     * @param id The ID of the category to retrieve.
     * @return The category with the specified ID, or null if not found.
     */
    Category getCategory(Long id);

    /**
     * Retrieves a specific category by its name.
     *
     * @param name The name of the category to retrieve.
     * @return The category with the specified name, or null if not found.
     */
    Category getCategoryByName(String name);

    /**
     * Deletes a category by its ID.
     *
     * @param id The ID of the category to delete.
     * @return A message indicating the result of the deletion operation.
     */
    String deleteCategory(Long id);

    /**
     * Creates a new category.
     *
     * @param category The category object to be created.
     * @return A message indicating the result of the creation operation.
     */
    String postCategory(Category category);

    /**
     * Updates an existing category with the specified ID.
     *
     * @param category The updated category object.
     * @param id The ID of the category to update.
     * @return A message indicating the result of the update operation.
     */
    String putCategory(Category category, Long id);

    /**
     * Ensures that the provided categories exist in the database.
     * If a category does not exist, it is created and added to the list of existing categories.
     *
     * @param categories The list of categories to ensure existence.
     * @return A list of categories with updated IDs (existing or newly created).
     */
    List<Category> categoriesExisting(List<Category> categories);
}