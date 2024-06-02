package co.unicauca.microservice.apirest.model.service;

import co.unicauca.microservice.apirest.model.entity.Product;

import java.util.List;

/**
 * Service interface for managing Product entities.
 */
public interface iProductService {

    /**
     * Retrieves all products from the database.
     *
     * @return A list of all products.
     */
    List<Product> getProducts();

    /**
     * Retrieves a specific product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The product with the specified ID, or null if not found.
     */
    Product getProduct(Long id);

    /**
     * Retrieves products by their name.
     *
     * @param name The name of the product(s) to retrieve.
     * @return A list of products matching the specified name.
     */
    List<Product> getProductByName(String name);

    /**
     * Retrieves products by a specific category name.
     *
     * @param nameCategory The name of the category to filter products by.
     * @return A list of products associated with the specified category.
     */
    List<Product> getProductByCategory(String nameCategory);

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to delete.
     * @return A message indicating the result of the deletion operation.
     */
    String deleteProduct(Long id);

    /**
     * Creates a new product.
     *
     * @param product The product object to be created.
     * @return A message indicating the result of the creation operation.
     */
    String postProduct(Product product);

    /**
     * Updates an existing product with the specified ID.
     *
     * @param product The updated product object.
     * @param id The ID of the product to update.
     * @return A message indicating the result of the update operation.
     */
    String putProduct(Product product, Long id);
}
